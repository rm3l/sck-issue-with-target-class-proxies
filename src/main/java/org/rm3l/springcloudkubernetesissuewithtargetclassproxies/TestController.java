package org.rm3l.springcloudkubernetesissuewithtargetclassproxies;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestController {

  private final TestService testService;
  private final ApplicationEventPublisher eventPublisher;

  TestController(final ApplicationEventPublisher eventPublisher, final TestService testService) {
    this.eventPublisher = eventPublisher;
    this.testService = testService;
  }

  @GetMapping("/test")
  public String test() {
    final String testData = this.testService.getTestData();
    this.eventPublisher.publishEvent(new TestServiceImpl.TestEvent(this, testData));
    return testData;
  }

}
