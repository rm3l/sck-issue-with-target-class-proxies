package org.rm3l.springcloudkubernetesissuewithtargetclassproxies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
public class SpringCloudKubernetesIssueWithTargetClassProxiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudKubernetesIssueWithTargetClassProxiesApplication.class, args);
	}

}
