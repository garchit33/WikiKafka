package com.spring.myproject.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.myproject.producer.service.KafkaProducerService;

@SpringBootApplication
public class SpringBootKafkaProducer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProducer.class);
	}
	
	@Autowired
	private KafkaProducerService kafkaProducerService;

	@Override
	public void run(String... args) throws Exception {
		kafkaProducerService.sendMessage();
	}
}
