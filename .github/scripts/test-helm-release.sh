#!/bin/bash

helm test sck-issue

export retVal=$?
echo "retVal=$retVal"

kubectl logs sck-issue-spring-cloud-k8s-issue-test-connection

exit $retVal
