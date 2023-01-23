package com.example.listener;

import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StringConsumerListener {
	
	private Logger logger = Logger.getLogger(StringConsumerListener.class.getName());
	
	@KafkaListener(groupId = "str-group", topics = "str-topic", containerFactory = "stringContainerFactory" )
	public void listener(String message) {
		logger.info(String.format("Recieved message %s", message));
	}

}
