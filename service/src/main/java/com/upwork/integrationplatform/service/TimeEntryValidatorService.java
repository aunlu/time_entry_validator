package com.upwork.integrationplatform.service;

import com.google.inject.Inject;
import com.odesk.agora.commons.hystrix.WsDependencyHysCmdBuilder;
import com.odesk.agora.hystrix.GenericWsDependencyHystrixCommand;
import com.odesk.agora.offlinetimerecords.cal.OfflineTimeRecordsDSHysCmdFactory;
import com.odesk.agora.offlinetimerecords.thrift.TOfflineTimeRecords;
import com.odesk.agora.thrift.common.TError;
import com.upwork.integrationplatform.core.api.model.Status;
import com.upwork.integrationplatform.core.api.urn.RequestType;
import com.upwork.integrationplatform.core.cal.CoreCmdFactory;
import com.upwork.integrationplatform.core.cal.CoreCmdFactory.SearchResponseCriteria;
import com.upwork.integrationplatform.core.cal.CoreCmdFactory.SearchResponseCriteria.SearchResponseCriteriaBuilder;
import com.upwork.integrationplatform.core.cal.WsHysCmdBuilder;
import com.upwork.integrationplatform.core.thrift.TResponse;
import com.upwork.integrationplatform.core.thrift.TResponseSearchResult;
import com.upwork.integrationplatform.dao.TimeEntryDao;
import com.upwork.integrationplatform.dao.pojo.TTRTimeEntry;
import com.upwork.integrationplatform.model.VGTimeEntry;
import com.upwork.integrationplatform.model.VGTimeEntryKey;
import com.upwork.integrationplatform.pro.thrift.TTimeEntry;
import com.upwork.integrationplatform.utils.CsvUtils;
import com.upwork.integrationplatform.utils.ObjectMapperUtils;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class TimeEntryValidatorService {

    private final OfflineTimeRecordsDSHysCmdFactory offlineTimeRecordsDSHysCmdFactory;
    private final TimeEntryDao timeEntryDao;

    private static final String PARTNER_ID = "iworkglobal";

    private final CoreCmdFactory coreCmdFactory;

    private Client client = ClientBuilder.newClient();

    @Inject
    public TimeEntryValidatorService(
            OfflineTimeRecordsDSHysCmdFactory offlineTimeRecordsDSHysCmdFactory, TimeEntryDao timeEntryDao,
            CoreCmdFactory coreCmdFactory) {
        this.offlineTimeRecordsDSHysCmdFactory = offlineTimeRecordsDSHysCmdFactory;
        this.timeEntryDao = timeEntryDao;
        this.coreCmdFactory = coreCmdFactory;
    }

    //    @SneakyThrows
    private List<VGTimeEntry> readCsv() {
        try {
            return CsvUtils.readAllRecords(
                    Path.of("/home/aunlu/Downloads/DumpOfTimeEntryRecords_28-04-2022.csv"), VGTimeEntry.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void compareVGdataWithTTRapi() {
        log.info("TimeEntryValidator start");

        List<VGTimeEntry> vgTimeEntries = readCsv();
        Map<VGTimeEntryKey, List<VGTimeEntry>> vgTimeEntryMap = vgTimeEntries.stream().collect(Collectors.groupingBy(
                vgTimeEntry -> new VGTimeEntryKey(vgTimeEntry.getContractId(), vgTimeEntry.getDate())));
        AtomicInteger contractsWithSameEntryCount = new AtomicInteger();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        AtomicInteger count = new AtomicInteger();
        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        int totalSize = vgTimeEntryMap.size();
        try {
            customThreadPool.submit(() -> {
                vgTimeEntryMap.entrySet().parallelStream().forEach(entry -> {
                    try {
                        VGTimeEntryKey vgTimeEntryKey = entry.getKey();
                        List<VGTimeEntry> vgTimeEntryList = entry.getValue();
                        LocalDate date = LocalDate.from(dateTimeFormatter.parse(vgTimeEntryKey.getDate()));
                        vgTimeEntryList.forEach(vgTimeEntry -> {
                            vgTimeEntry.setWorkDate(date);
                            timeEntryDao.createVGTimeEntry(vgTimeEntry);
                        });

                        GenericWsDependencyHystrixCommand<TOfflineTimeRecords> timeEntriesCommand = getTimeEntries(
                                vgTimeEntryKey.getContractId(), Date.valueOf(date));
                        TOfflineTimeRecords timeRecords = timeEntriesCommand.execute();
                        //                log.info("TOfflineTimeRecords for contractId {}, date {}: {}", contractId, date,
                        //                        timeRecords.toString());
                        timeRecords.getRecords().forEach(tOfflineTimeRecord -> {
                            int id = timeEntryDao.createTTRTimeEntry(
                                    TTRTimeEntry.fromTOfflineTimeRecord(tOfflineTimeRecord));
                            //                    log.info("insert timeEntry {}", id);
                        });
                        if (vgTimeEntryList.size() == timeRecords.getRecordsSize()) {
                            contractsWithSameEntryCount.getAndIncrement();
                        }
                        int i = count.getAndIncrement();
                        if (i % 100 == 0) {
                            log.info("count {} / {}", i, totalSize);
                        }
                        //                Thread.sleep(10);
                    } catch (Exception e) {
                        log.error("Exception for key " + entry.getKey(), e);
                    }
                });
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("", e);
        }
        customThreadPool.shutdown();
        log.info("total number of contractId-date pairs {}, same count {}", totalSize,
                contractsWithSameEntryCount);
        log.info("TimeEntryValidator end");

    }

    public GenericWsDependencyHystrixCommand<TOfflineTimeRecords> getTimeEntries(Long contractId, Date date) {
        GenericWsDependencyHystrixCommand<TOfflineTimeRecords> cmd =
                new WsDependencyHysCmdBuilder<TOfflineTimeRecords>("offlineTimeRecordsDS", "getTimeEntries")
                        .path(String.format(
                                "/proxy/offlineTimeRecordsDS-v.1.1.10/api/offline-time-records/contracts/%d/date/%s",
                                contractId,
                                date.toString()
                        ))
                        .mapErrorResponse(new ResponseFromError("getTimeEntries"))
                        .get(TOfflineTimeRecords.class);

        return cmd;
    }

    public void getTimeEntryResponsesFromPRO() {
        long offset = 0L;
        int limit = 100;
        SearchResponseCriteriaBuilder criteriaBuilder = SearchResponseCriteria.builder()
                .statuses(Collections.singletonList(Status.VALIDATION_ERROR))
                .limit(limit)
                .type(RequestType.GET_TIME_ENTRIES.getUrn());

        TResponseSearchResult searchResult;
        List<TTimeEntry> records = new ArrayList<>();
        do {
            SearchResponseCriteria criteria = criteriaBuilder.offset(offset).build();
            searchResult = getSearchResponses(criteria, PARTNER_ID);

            List<TTimeEntry> page = searchResult.getItems()
                    .stream()
                    .map(tResponse -> ObjectMapperUtils.fromJson(tResponse.getPayload(), TTimeEntry.class))
                    .collect(Collectors.toList());
            log.info("response for criteria {}, {}", criteria, page.size());
            records.addAll(page);
            offset += limit;
        } while (searchResult.isHasMore() && records.size() < 1000);
        log.info("records length {}", records.size());
    }

    private GenericWsDependencyHystrixCommand<TResponseSearchResult> createSearchResponsesCmd(
            @NotNull CoreCmdFactory.SearchResponseCriteria criteria, @Nullable String partnerId) {
        return new WsDependencyHysCmdBuilder<TResponseSearchResult>("partnerRequestOrchestrator", "searchResponses")
                .path("/proxy/partnerRequestOrchestrator-v.1.29.22/v1/uip/ic/response")
                .queryParam("partnerId", partnerId).queryParam("type", criteria.getType())
                .queryParam("status", criteria.getStatuses()).queryParam("limit", criteria.getLimit()).
                queryParam("offset", criteria.getOffset()).queryParam("negateStatuses", criteria.isNegateStatuses())
                .mapErrorResponse(new ResponseFromError("getTimeEntries")).get(TResponseSearchResult.class);
    }

    private TResponseSearchResult getSearchResponses(SearchResponseCriteria criteria, String partnerId) {
        WebTarget webTarget = client
                .target("http://swagger.prod.platform.usw2.upwork")
                .path("/proxy/partnerRequestOrchestrator-v.1.29.22/v1/uip/ic/response")
                .queryParam("partnerId", partnerId).queryParam("type", criteria.getType())
                .queryParam("limit", criteria.getLimit()).
                queryParam("offset", criteria.getOffset()).queryParam("negateStatuses", criteria.isNegateStatuses());
        for (Status status : criteria.getStatuses()) {
            webTarget = webTarget.queryParam("status", status);
        }

        return webTarget.request(MediaType.APPLICATION_JSON)
                .get(TResponseSearchResult.class);
    }

    private static class ResponseFromError implements Function<Response, TError> {

        private final String commandName;

        ResponseFromError(String commandName) {
            this.commandName = commandName;
        }

        public TError apply(Response response) {
            TError tError;
            try {
                tError = response.readEntity(TError.class);
            } catch (ProcessingException | IllegalStateException e) {
                log.warn("Error getting TError from response. Error status : " + response.getStatus(), e);
                tError = new TError(
                        "Error: Service didn't respond with TError entity. serviceName: offlineTimeRecordsDS, commandName: '"
                                + commandName + "', Http status: " + response.getStatus());
            }
            tError.setCode(response.getStatus());
            return tError;
        }
    }
}
