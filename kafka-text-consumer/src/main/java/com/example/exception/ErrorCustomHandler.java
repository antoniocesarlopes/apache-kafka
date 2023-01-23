package com.example.exception;

import java.util.logging.Logger;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
	
	private Logger logger = Logger.getLogger(ErrorCustomHandler.class.getName());

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		logger.info(String.format("ERROR CAPTURED ::: %s", exception.getMessage()));
		return null;
	}

}
