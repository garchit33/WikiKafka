package com.spring.myproject.test;

import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@Configuration
public class KafkaTestConfig {

	@Container
	static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka"));
	
	static {
		kafka.start();
		System.out.println("Kafka Port: "+ kafka.getBootstrapServers());
		System.setProperty("org.kafka.bootstrap-servers", kafka.getBootstrapServers());
	}
}
