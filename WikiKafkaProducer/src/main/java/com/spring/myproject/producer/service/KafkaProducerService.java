package com.spring.myproject.producer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class KafkaProducerService {

	private static final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public String sendMessage() throws InterruptedException {
		log.info("Inside [KafkaProducerService -> sendMessage()]");
		
		String topic = "wikimedia_recentchanges";
		
		EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder eventBuilder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = eventBuilder.build();
		eventSource.start();
		log.info("[KafkaProducerService -> sendMessage()] Sending Events to topic");
		
		TimeUnit.MINUTES.sleep(10);
		return "Sent Message Sucessfully";
	}
}
