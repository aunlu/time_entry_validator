package com.upwork.integrationplatform;

import com.codahale.metrics.annotation.Timed;
import com.odesk.agora.Resource;
import com.google.inject.Inject;
import com.upwork.integrationplatform.service.TimeEntryValidatorService;
import com.upwork.integrationplatform.thrift.Ttest;
import java.time.LocalDateTime;
import java.util.UUID;
import org.apache.shiro.authz.permission.DomainPermission;
import org.apache.shiro.subject.Subject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.time.LocalTime;

@Path("validator")
public class DSResource extends Resource {

    @Inject
    private Subject subject;

    @Inject
    private TimeEntryValidatorService timeEntryValidatorService;

    /**
     * Get entity by uid without a permission check
     *
     * @param uid the uid of the entity
     * @return the entity
     */
    @GET
    @Path("ttr")
    @Timed
    public Ttest getEntity(@PathParam("uid") final String uid) {
        timeEntryValidatorService.compareVGdataWithTTRapi();
        String ts = LocalDateTime.now().toString();
        return new Ttest(UUID.randomUUID().toString(), ts, ts);
    }

    @GET
    @Path("pro")
    @Timed
    public Ttest runGetProResponses(@PathParam("uid") final String uid) {
        timeEntryValidatorService.getTimeEntryResponsesFromPRO();
        String ts = LocalDateTime.now().toString();
        return new Ttest(UUID.randomUUID().toString(), ts, ts);
    }

    /**
     * Get entity by uid with a permission check
     *
     * @param uid the uid of the entity
     * @return the entity
     */
    @GET
    @Path("private/{permissionKey}/{uid}")
    @Timed
    public Ttest getEntity(@PathParam("permissionKey") String permissionKey, @PathParam("uid") final String uid) {
        checkPermission("read", permissionKey);
        Ttest result = new Ttest();
        result.setUid(uid);
        result.setCreatedTs(String.valueOf(LocalTime.now()));
        result.setUpdatedTs(String.valueOf(LocalTime.now()));
        return result;
    }

    /**
     * Save Ttest entity.
     *
     * @param payload entity to be saved
     * @return uid of new entity
     */
    @POST
    @Timed
    public String createEntity(final Ttest payload) {
        return "uidOfNewlyCreatedEntity";
    }

    private void checkPermission(String actions, String targets) {
        subject.checkPermission(new DomainPermission(actions, targets));
    }
}
