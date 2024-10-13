package com.spring.myproject.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicBuilderConfig {

	private static final Logger log = LoggerFactory.getLogger(TopicBuilderConfig.class);
	
	@Bean
	public NewTopic topic() {
		log.info("[TopicBuilderConfig - topic()] Setting the configuration for Topic");
		return TopicBuilder.name("wikimedia_recentchanges").build();
	}
}
