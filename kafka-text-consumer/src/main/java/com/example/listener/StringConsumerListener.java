package com.example.listener;

import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import com.example.listener.custom.StringConsumercCustomListener;

@Component
public class StringConsumerListener {

	private Logger logger = Logger.getLogger(StringConsumerListener.class.getName());

	@KafkaListener(groupId = "str-group-1", 
			topicPartitions = { 
					@TopicPartition(topic = "str-topic", partitions = {"0"})}, 
			containerFactory = "checkStringContainerFactory" )
	public void listenerTest1(String message) {
		logger.info(String.format("TEST 1 ::: Recieved message %s", message));
	}

	@KafkaListener(groupId = "str-group-1", 
			topicPartitions = { 
					@TopicPartition(topic = "str-topic", partitions = {"1"})}, 
			containerFactory = "checkStringContainerFactory" )
	public void listenerTest2(String message) {
		logger.info(String.format("TEST 2 ::: Recieved message %s", message));
	}

	//Escuta as duas partições
	//@KafkaListener(groupId = "str-group-2", topics = "str-topic", containerFactory = "stringContainerFactory" )
	@StringConsumercCustomListener(groupId = "str-group-2")
	public void listenerTest3(String message) {
		logger.info(String.format("TEST 3 ::: Recieved message %s", message));
	}

}
