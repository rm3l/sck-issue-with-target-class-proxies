
```
export IMAGE_REPOSITORY="localhost:5000/org.rm3l/spring-cloud-k8s-issue"
export IMAGE_TAG="latest"
```

```
./mvnw package jib:build \
    -Djib.to.image=${IMAGE_REPOSITORY}:${IMAGE_TAG} \
    -Djib.allowInsecureRegistries=true
```

```
helm upgrade --install sck-issue \
    src/main/kubernetes/helm-chart \
    --namespace default \
    --set image.repository=${IMAGE_REPOSITORY} \
    --set image.tag=${IMAGE_TAG} \
    --set image.pullPolicy=Always
```

```
helm test sck-issue --namespace default
```
