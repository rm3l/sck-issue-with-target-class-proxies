package org.rm3l.springcloudkubernetesissuewithtargetclassproxies;

import java.util.UUID;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends AbstractTestService implements TestService {

  @Override
  public String getTestData() {
    return UUID.randomUUID().toString();
  }

  //Using target-class based proxies with Spring Cloud Kubernetes makes the application fail to
  //start when running in a Kubernetes cluster
  @EventListener(TestEvent.class)
  @Async
  public void handleEvent(final TestEvent testEvent) {
    logger.info("handleEvent({})", testEvent.data);
  }

  public static class TestEvent extends ApplicationEvent {

    public final String data;

    public TestEvent(Object source, String data) {
      super(source);
      this.data = data;
    }
  }
}
