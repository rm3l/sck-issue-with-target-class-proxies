package org.rm3l.springcloudkubernetesissuewithtargetclassproxies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestController {

  private final TestService testService;

  TestController(final TestService testService) {
    this.testService = testService;
  }

  @GetMapping("/test")
  public String test() {
    return this.testService.getTestData();
  }

}
