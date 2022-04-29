package com.upwork.integrationplatform.dao.pojo;

import com.odesk.agora.offlinetimerecords.thrift.TOfflineTimeRecord;
import com.upwork.enterprise.commons.dao.mappers.bean.JdbiBean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class TTRTimeEntry implements JdbiBean {

    private UUID id;
    private String offerId;
    private LocalDate workDate;
    private long contractId;
    private UUID partnerAssignmentId;
    private String partnerId;
    private String timeType;
    private String entryType;
    private int minutes;
    private String status;
    private int roundedMinutes;
    private double payRate;
    private double providerMarkup;
    private double clientMarkup;
    private double grossPaid;
    private double grossPaidWithMarkups;
    private double taxes;
    private double localTaxes;
    private String currency;
    private boolean isBillable;
    private LocalDateTime originalCreatedAt;
    private LocalDateTime originalLastModified;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

    public boolean getIsBillable() {
        return isBillable;
    }

    public static TTRTimeEntry fromTOfflineTimeRecord(TOfflineTimeRecord tOfflineTimeRecord) {
        TTRTimeEntry timeEntry = new TTRTimeEntry();
        timeEntry.setId(UUID.fromString(tOfflineTimeRecord.getId()));
        timeEntry.setOfferId(tOfflineTimeRecord.getOfferId());
        timeEntry.setWorkDate(LocalDate.parse(tOfflineTimeRecord.getWorkDate()));
        timeEntry.setContractId(tOfflineTimeRecord.getContractId());
        timeEntry.setPartnerAssignmentId(UUID.fromString(tOfflineTimeRecord.getPartnerAssignmentId()));
        timeEntry.setPartnerId(tOfflineTimeRecord.getPartnerId());
        timeEntry.setTimeType(tOfflineTimeRecord.getTimeType());
        timeEntry.setEntryType(tOfflineTimeRecord.getEntryType());
        timeEntry.setMinutes(tOfflineTimeRecord.getMinutes());
        timeEntry.setStatus(tOfflineTimeRecord.getStatus());
        timeEntry.setRoundedMinutes(tOfflineTimeRecord.getRoundedMinutes());
        timeEntry.setPayRate(tOfflineTimeRecord.getPayRate());
        timeEntry.setProviderMarkup(tOfflineTimeRecord.getProviderMarkup());
        timeEntry.setClientMarkup(tOfflineTimeRecord.getClientMarkup());
        timeEntry.setGrossPaid(tOfflineTimeRecord.getGrossPaid());
        timeEntry.setGrossPaidWithMarkups(tOfflineTimeRecord.getGrossPaidWithMarkups());
        timeEntry.setTaxes(tOfflineTimeRecord.getTaxes());
        timeEntry.setLocalTaxes(tOfflineTimeRecord.getLocalTaxes());
        timeEntry.setCurrency(tOfflineTimeRecord.getCurrency());
        timeEntry.setBillable(tOfflineTimeRecord.isIsBillable());
        timeEntry.setOriginalCreatedAt(LocalDateTime.parse(tOfflineTimeRecord.getOriginalCreatedAt()));
        timeEntry.setTimeIn(LocalDateTime.parse(tOfflineTimeRecord.getTimeIn()));
        timeEntry.setTimeOut(LocalDateTime.parse(tOfflineTimeRecord.getTimeOut()));
        return timeEntry;
    }
}
