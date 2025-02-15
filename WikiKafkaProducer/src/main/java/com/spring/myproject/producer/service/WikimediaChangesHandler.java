package com.spring.myproject.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangesHandler implements EventHandler {

	private static final Logger log = LoggerFactory.getLogger(WikimediaChangesHandler.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private String topic;
	
	public WikimediaChangesHandler(KafkaTemplate<String, String> template, String topic) {
		this.kafkaTemplate = template;
		this.topic = topic;
	}
	
	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		log.info("[WikimediaChangesHandler -> onMessage()] Receiving message events from Wikimedia" + messageEvent.getData());
		kafkaTemplate.send(topic, messageEvent.getData());
	}
	
	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}
}
