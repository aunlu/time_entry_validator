
-- contract-workday pair count TTR
select count(*)
from (select "contractId", "workDate" from "TTRTimeEntry" group by "contractId", "workDate") as cIwD;

-- contract-workday pair count VG
select count(*)
from (select "contractId", "workDate" from vg_time_entry group by "contractId", "workDate") as vg;

-- sum diff less than 1
select count(*)
from (select "contractId", "workDate", count(*) c, sum("grossPaidWithMarkups"::numeric) s
      from "TTRTimeEntry"
      group by "contractId", "workDate") ttr
         join (select "contractId", "workDate", count(*) c, sum(round("endClientBill"::numeric, 2)) s
               from vg_time_entry
               group by "contractId", "workDate") vg
              on ttr."contractId" = vg."contractId" and ttr."workDate" = vg."workDate"
where ABS(ttr.s - vg.s) < 1;

-- record count equals
select count(*)
from (select "contractId", "workDate", count(*) c, sum("grossPaidWithMarkups"::numeric) s
      from "TTRTimeEntry"
      group by "contractId", "workDate") ttr
         join (select "contractId", "workDate", count(*) c, sum(round("endClientBill"::numeric, 2)) s
               from vg_time_entry
               group by "contractId", "workDate") vg
              on ttr."contractId" = vg."contractId" and ttr."workDate" = vg."workDate"
where ttr.c = vg.c;
