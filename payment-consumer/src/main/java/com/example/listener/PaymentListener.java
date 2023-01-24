package com.example.listener;

import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.model.Payment;

import static java.lang.Thread.sleep;

@Component
public class PaymentListener {
	
	private Logger logger = Logger.getLogger(PaymentListener.class.getName());

    @KafkaListener(topics = "payment-topic", groupId = "security-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) throws InterruptedException {
    	logger.info(String.format("Recebi o pagamento %s", payment.toString()));
        sleep(2000);
        logger.info("Validando fraude...");
        sleep(2000);

        logger.info("Compra aprovada...");
        sleep(2000);
    }

    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) throws InterruptedException {
        sleep(4000);
        logger.info(String.format("Gerando PDF do produto de id %s...", payment.getId()));
        sleep(4000);
    }

    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() throws InterruptedException {
        sleep(5000);
        logger.info("Enviando email de confirmacao...");
    }
	
}
