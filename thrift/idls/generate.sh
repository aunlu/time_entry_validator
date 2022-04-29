#!/bin/sh

SCRIPT_DIR=`dirname "$0"`
COMMON_THRIFT_PARAMS="-r -v -out ../src/main/java --gen java:beans,generated_annotations=undated"

cd "${SCRIPT_DIR}"

# Thrift compiler doesn't allow multiple thrift files to be compiled
# at one time. See: https://issues.apache.org/jira/browse/THRIFT-3013
# Thats why xargs used:

# find . -name "*.thrift" | xargs -L 1 thrift ${COMMON_THRIFT_PARAMS}

# But this variant commented because of sometimes we don't need
# to generate code for all thrift files.
#
# Example: some thrift files can include only stubs
# See marketplace-openings project for real life examples:
#
#     https://stash.odesk.com/projects/CAT/repos/marketplace-openings/browse/thrift/idls
#
# Discussion thread:
#
#     https://stash.odesk.com/projects/OMAHA/repos/omaha-archetype/pull-requests/36/overview
#
# Alexander Paderin already tried to workaround this issue in VegaJobDetailsV2 project:
#
#     https://stash.odesk.com/projects/CAT/repos/vegajobdetailsv2/browse/thrift/idls/create.sh
#

thrift ${COMMON_THRIFT_PARAMS} com.upwork.integrationplatform.thrift

