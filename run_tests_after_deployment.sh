#!/bin/bash

echo "If Jenkinsfile value of runTestsAfterDeployment is set to true the shell script will be executed after the stack sandbox deployment step passing the following arguments: stack id, container ip address, service port, admin port, statcher url"
echo "Stack ID: $1"
echo "Container IP address: $2"
echo "Service port: $3"
echo "Admin port: $4"
echo "Stitcher URL: $5"
echo "All CLI arguments: $@"
echo "======================="
echo "======================="
echo "======================="
echo "curl -vvv \"http://$2:$4/healthcheck?pretty=true\""
curl -vvv "http://$2:$4/healthcheck?pretty=true"
