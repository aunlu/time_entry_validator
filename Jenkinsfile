#!groovy
// This makes use of the standard cicd approach and pipeline tooling documented here
// https://confluence.upworkcorp.com/display/CLEO/The+standard+CICD
// please reach out to us in ask-jenkins with any questions

standardAgoraPipeline {
    dockerBuildImage = "739939173819.dkr.ecr.us-west-1.amazonaws.com/upwork/maven:3.6-amazoncorretto-11"
    // It is recommended to not use dev environment at all. Always prefer testing in staging in isolation with a sandbox.
    // When testing in isolation is not possible, and changes can potentially break the shared environment,
    // deploy into shared dev. This can be done on the fly with a git commit command, or by enabling this option.
    // This will result in "develop" branch always deployed directly into the shared dev environment:
    deployDevelopIntoSharedDev = false

    // When enabled, the tooling will execute bash script file named "run_tests_after_deployment.sh"
    // passing stack id, ip, port and stitcher url as parameters. The pipeline will automatically deploy a sandbox
    // for these tests and will delete it afterwards regardless of the outcome.
    runTestsAfterDeployment = true

    // Set to true only for new applications that are not ready to be deployed to production yet.
    // When ready, this should be set to false, which will initate the first production deployment.
    // Do not use Taxis UI for production deployments, unless for emergency remediation.
    disableProductionDeployments = true

    // Below values should match exactly what is found in https://class.techops.platform.usw2.upwork/#/
    // In general, avoid changing these
    serviceName = 'validatorService'
    team = 'ip'
    teamPa = 'abdulhakimunlu'
    teamEmail = 'scrum-integration-platform@upwork.com'
    teamTaxisServiceAccount = 'test'
    jiraProject = 'testJira'
    slackChannel = 'validatorChannel'
    bitbucketProject = 'time-entry-validator'
}