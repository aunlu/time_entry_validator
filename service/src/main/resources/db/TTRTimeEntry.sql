create table "TTRTimeEntry"
(
    id                     uuid not null,
    "offerId"              varchar,
    "workDate"             date not null,
    "partnerAssignmentId"  uuid,
    "partnerId"            varchar,
    "timeType"             varchar,
    "entryType"            varchar,
    minutes                integer,
    status                 varchar,
    "roundedMinutes"       integer,
    "payRate"              double precision,
    "providerMarkup"       double precision,
    "clientMarkup"         double precision,
    "grossPaid"            double precision,
    "grossPaidWithMarkups" double precision,
    taxes                  double precision,
    "localTaxes"           double precision,
    currency               varchar,
    "isBillable"           boolean,
    "originalCreatedAt"    timestamp,
    "originalLastModified" timestamp,
    "timeIn"               timestamp,
    "timeOut"              timestamp,
    "contractId"           integer
);

alter table "TTRTimeEntry"
    owner to admin;

create index ttrtimeentry_contractid_workdate_index2
    on "TTRTimeEntry" ("contractId", "workDate");

