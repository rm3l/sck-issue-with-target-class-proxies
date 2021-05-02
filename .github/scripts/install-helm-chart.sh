#!/bin/bash

helm install --wait --timeout 3m sck-issue \
  src/main/kubernetes/helm-chart \
  --set image.repository=kind-registry:5000/org.rm3l/sck8s-issue-target-class-proxies \
  --set image.tag=latest \
  --set image.pullPolicy=Always

export retVal=$?
echo "retVal=$retVal"

kubectl logs \
  $(kubectl get pods \
      -l "app.kubernetes.io/name=spring-cloud-k8s-issue,app.kubernetes.io/instance=sck-issue" \
      -o jsonpath="{.items[0].metadata.name}")

exit $retVal
