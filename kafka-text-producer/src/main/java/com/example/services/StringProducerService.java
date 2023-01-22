package com.example.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class StringProducerService {

	private Logger logger = Logger.getLogger(StringProducerService.class.getName());
	private static final String MESSAGE_TOPIC = "str-topic";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		kafkaTemplate.send(MESSAGE_TOPIC, message)
		.thenAccept(this::onSuccess)
		.exceptionally(this::onFailure);
	}

	private void onSuccess(final SendResult<String, String> result) {
		String messageTemplate = "The message has sent successfully. Topic: %s Message: %s Partition: %s Offset: %s ";
		logger.info(String.format(messageTemplate, 
				result.getProducerRecord().topic(), 
				result.getProducerRecord().value(), 
				result.getRecordMetadata().partition(), 
				result.getRecordMetadata().offset()));
	}

	private Void onFailure(final Throwable t) {
		String messageTemplate = "Unable to write the message to topic %s.";
		logger.log(Level.SEVERE, String.format(messageTemplate, MESSAGE_TOPIC), t);
		return null;
	}
}
