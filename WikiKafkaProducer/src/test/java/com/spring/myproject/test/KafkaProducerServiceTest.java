package com.spring.myproject.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.spring.myproject.producer.service.KafkaProducerService;

@SpringBootTest(classes = KafkaProducerService.class)
//@EmbeddedKafka(brokerProperties = {"listeners=PLAINTEXT://localhost:9092"})
@ContextConfiguration(classes = KafkaTestConfig.class)
@Testcontainers
public class KafkaProducerServiceTest {

	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@MockBean
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Test
	void sendMessageTest() throws InterruptedException {
		String message = kafkaProducerService.sendMessage();
		assertEquals("Sent Message Sucessfully", message);
		
	}
}
