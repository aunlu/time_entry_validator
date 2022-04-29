@echo off 
SET mypath=%~dp0
cd %mypath%

set THRIFTPARAMS=-r -v -out ..\src\main\java --gen java:beans,hashcode,generated_annotations=undated

rem Because Thrift compiler doesn't allow to give multiple *.thrift files
rem as argument (see: https://issues.apache.org/jira/browse/THRIFT-3013),
rem we have to iterate with for loop:

rem for /r %%v in (*.thrift) do thrift %THRIFTPARAMS% "%%v"

rem But this variant commented because of sometimes we don't need
rem to generate code for all thrift files.
rem
rem Example: some thrift files can include only stubs
rem See marketplace-openings project for real life examples:
rem
rem     https://stash.odesk.com/projects/CAT/repos/marketplace-openings/browse/thrift/idls
rem
rem Discussion thread:
rem
rem     https://stash.odesk.com/projects/OMAHA/repos/omaha-archetype/pull-requests/36/overview
rem
rem Alexander Paderin already tried to workaround this issue in VegaJobDetailsV2 project:
rem
rem     https://stash.odesk.com/projects/CAT/repos/vegajobdetailsv2/browse/thrift/idls/create.sh
rem

thrift %THRIFTPARAMS% com.upwork.integrationplatform.thrift
