package com.spring.myproject.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerDatabaseService {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerDatabaseService.class);
	
	@KafkaListener(topics = "wikimedia_recentchanges", groupId = "myGroup")
	public void consumeMessages(String messageEvents) {
		log.info("[KafkaConsumerDatabaseService -> consumeMessages()] Received Message events by Consumer -> "+ messageEvents);
	}
}
