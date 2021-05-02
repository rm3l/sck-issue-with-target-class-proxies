package org.rm3l.springcloudkubernetesissuewithtargetclassproxies;

import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestController {

  private final Callable<String> testService;
  private final ApplicationEventPublisher eventPublisher;

  @Autowired
  TestController(final ApplicationEventPublisher eventPublisher,
      @Qualifier("testServiceImpl") final Callable<String> testService) {
    this.eventPublisher = eventPublisher;
    this.testService = testService;
  }

  @GetMapping("/test")
  public String test() throws Exception {
    final String testData = this.testService.call();
    this.eventPublisher.publishEvent(new TestServiceImpl.TestEvent(this, testData));
    return testData;
  }

}
