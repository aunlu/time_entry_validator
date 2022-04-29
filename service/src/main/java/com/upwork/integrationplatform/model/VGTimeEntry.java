package com.upwork.integrationplatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDate;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "AssignmentHourID", "AssignmentHourGUID", "AssignmentID", "AssignmentGUID", "ContactID", "Date", "Reg", "OT", "DT",
        "Expenses", "Pay", "Bill", "EndClientBill", "PayRate", "BillRate", "EndClientBillRate", "CreationDate",
        "LastModifiedDate", "StatusID", "IntegrationStatusID", "QueueIndex"})
public class VGTimeEntry {

    @JsonProperty("AssignmentHourID")
    private String assignmentHourID;

    @JsonProperty("AssignmentHourGUID")
    private String assignmentHourGUID;

    @JsonProperty("AssignmentID")
    private String assignmentID;

    @JsonProperty("AssignmentGUID")
    private String assignmentGUID;

    @JsonProperty("ContactID")
    private Long contractId;

    @JsonProperty("Date")
    private String date;

    @JsonProperty("Reg")
    private String reg;

    @JsonProperty("OT")
    private String ot;

    @JsonProperty("DT")
    private String dt;

    @JsonProperty("Expenses")
    private String expenses;

    @JsonProperty("Pay")
    private Double pay;

    @JsonProperty("Bill")
    private Double bill;

    @JsonProperty("EndClientBill")
    private Double endClientBill;

    @JsonProperty("PayRate")
    private Double payRate;

    @JsonProperty("BillRate")
    private Double billRate;

    @JsonProperty("EndClientBillRate")
    private Double endClientBillRate;

    @JsonProperty("CreationDate")
    private String creationDate;

    @JsonProperty("LastModifiedDate")
    private String lastModifiedDate;

    @JsonProperty("StatusID")
    private Integer statusID;

    @JsonProperty("IntegrationStatusID")
    private Integer integrationStatusID;

    @JsonProperty("QueueIndex")
    private Integer queueIndex;

    @JsonIgnore
    private LocalDate workDate;
}
