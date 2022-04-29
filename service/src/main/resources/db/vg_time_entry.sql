create table vg_time_entry
(
    "AssignmentHourID"    varchar,
    "AssignmentHourGUID"  varchar,
    "AssignmentID"        varchar,
    "AssignmentGUID"      varchar,
    "contractId"          integer,
    "Date"                varchar,
    reg                   varchar,
    ot                    varchar,
    dt                    varchar,
    expenses              varchar,
    pay                   double precision,
    bill                  double precision,
    "endClientBill"       double precision,
    payrate               double precision,
    billrate              double precision,
    "endClientBillRate"   double precision,
    "creationDate"        varchar,
    "lastModifiedDate"    varchar,
    "statusID"            integer,
    integration_status_id integer,
    queueindex            integer,
    "workDate"            date
);

alter table vg_time_entry
    owner to admin;

create index vg_time_entry_contractid_workdate_index
    on vg_time_entry ("contractId", "workDate");

