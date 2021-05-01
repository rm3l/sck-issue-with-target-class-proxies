package org.rm3l.springcloudkubernetesissuewithtargetclassproxies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//FIXME Issue boils down to EnableAsync and @Async on @EventListener
@EnableAsync(mode = AdviceMode.PROXY, proxyTargetClass = true)
public class SpringCloudKubernetesIssueWithTargetClassProxiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudKubernetesIssueWithTargetClassProxiesApplication.class, args);
	}

}
