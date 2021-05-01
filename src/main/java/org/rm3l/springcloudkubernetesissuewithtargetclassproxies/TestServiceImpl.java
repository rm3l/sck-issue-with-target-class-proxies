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
    logger.debug("handleEvent({})", testEvent);
  }

  public static class TestEvent extends ApplicationEvent {
    public TestEvent(Object source) {
      super(source);
    }
  }
}
