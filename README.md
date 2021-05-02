> Sample Project demonstrating an issue with Spring Cloud Kubernetes

### Link to issue 
TODO

### How to reproduce the issue

This issue appears when deploying the application to a Kubernetes cluster.
I am using a [Kind cluster](https://kind.sigs.k8s.io/) locally, but feel free to use anything else.

```
export IMAGE_REPOSITORY="localhost:5000/org.rm3l/spring-cloud-k8s-issue"
export IMAGE_TAG="latest"
```

```
# Package the application and push the container image to your registry
./mvnw package jib:build \
    -Djib.to.image=${IMAGE_REPOSITORY}:${IMAGE_TAG} \
    -Djib.allowInsecureRegistries=true
```

```
# Deploy the application to your Kubernetes Cluster using the Helm Chart provided
helm upgrade --install sck-issue \
    src/main/kubernetes/helm-chart \
    --set image.repository=${IMAGE_REPOSITORY} \
    --set image.tag=${IMAGE_TAG} \
    --set image.pullPolicy=Always
```

```
# This test pod will not complete successfully
helm test sck-issue
```
