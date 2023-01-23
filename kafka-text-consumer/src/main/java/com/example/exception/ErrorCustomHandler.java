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
		logger.info("ERROR CAPTURED WHEN SENDIND MESSAGE");
		logger.info(String.format("Payload ::: %s", message.getPayload()));
		logger.info(String.format("Headers ::: %s", message.getHeaders()));
		logger.info(String.format("Offset ::: %s", message.getHeaders().get("kafka_offset")));
		logger.info(String.format("Message exception ::: %s", exception.getMessage()));
        return null;
    }

//    @Override
//    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//    }

}
