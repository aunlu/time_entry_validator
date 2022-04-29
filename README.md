# time_entry_validator

1. create db tables using TTRTimeEntry.sql and vg_time_entry.sql
2. set the db parameters in test.config.xml
3. set the local csv file path in com.upwork.integrationplatform.service.TimeEntryValidatorService.readCsv
4. start DSService with "o2server test" jvm parameters.
5. call com.upwork.integrationplatform.DSResource.getEntity(java.lang.String) endpoint to trigger validation
6. use the queries in comparison-queries.sql to compare records manually.
