
```
./mvnw package jib:build \
    -Djib.to.image=localhost:5000/org.rm3l/spring-cloud-k8s-issue:latest \
    -Djib.allowInsecureRegistries=true
```

```
helm upgrade --install sck-issue \
    src/main/kubernetes/helm-chart \
    --namespace default \
    --set image.tag=latest \
    --set image.pullPolicy=Always
```

```
helm test sck-issue --namespace default
```
