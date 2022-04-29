package com.upwork.integrationplatform.dao;

import com.upwork.enterprise.commons.dao.mappers.EntityAutoMapperFactory;
import com.upwork.integrationplatform.dao.pojo.TTRTimeEntry;
import com.upwork.integrationplatform.model.VGTimeEntry;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.sqlobject.mixins.GetHandle;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;

@UseStringTemplate3StatementLocator
@RegisterMapperFactory(EntityAutoMapperFactory.class)
public abstract class TimeEntryDao implements Transactional<TimeEntryDao>, GetHandle {

    @SqlUpdate(
            "insert into \"TTRTimeEntry\" (id, \"offerId\", \"workDate\", \"partnerAssignmentId\", \"partnerId\", \"timeType\", \"entryType\", minutes, status,"
                    + "                            \"roundedMinutes\", \"payRate\", \"providerMarkup\", \"clientMarkup\", \"grossPaid\", \"grossPaidWithMarkups\","
                    + "                            \"taxes\", \"localTaxes\", currency, \"isBillable\", \"originalCreatedAt\", \"originalLastModified\", \"timeIn\","
                    + "                            \"timeOut\",\"contractId\")"
                    + " values (:id, :offerId, :workDate, :partnerAssignmentId, :partnerId, :timeType, :entryType, :minutes, :status,"
                    + "                             :roundedMinutes, :payRate, :providerMarkup, :clientMarkup, :grossPaid, :grossPaidWithMarkups,"
                    + "                             :taxes, :localTaxes, :currency, :isBillable, :originalCreatedAt, :originalLastModified, :timeIn,"
                    + "                             :timeOut, :contractId)")
    public abstract int createTTRTimeEntry(@BindBean TTRTimeEntry ttrTimeEntry);

    @SqlUpdate(
            "insert into vg_time_entry (\"AssignmentHourID\", \"AssignmentHourGUID\", \"AssignmentID\", \"AssignmentGUID\", \"contractId\", \"Date\", reg,"
                    + "ot, dt, expenses, pay, bill, \"endClientBill\", payrate, billrate, \"endClientBillRate\","
                    + "\"creationDate\", \"lastModifiedDate\", \"statusID\", integration_status_id, queueindex, \"workDate\")"
                    + "values (:assignmentHourID, :assignmentHourGUID, :assignmentID, :assignmentGUID, :contractId, :date, :reg, :ot, :dt, :expenses, :pay, "
                    + ":bill, :endClientBill, :payRate, :billRate, :endClientBillRate, :creationDate, :lastModifiedDate, :statusID, :integrationStatusID, "
                    + ":queueIndex, :workDate)")
    public abstract int createVGTimeEntry(@BindBean VGTimeEntry vgTimeEntry);

}
