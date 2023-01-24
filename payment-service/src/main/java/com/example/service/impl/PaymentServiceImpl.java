package com.example.service.impl;

import java.util.logging.Logger;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.model.Payment;
import com.example.service.PaymentService;
import com.example.util.Constantes.TOPICS;;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	private Logger logger = Logger.getLogger(PaymentServiceImpl.class.getName());
	
	private final KafkaTemplate<String, Payment> kafkaTemplate;
	
	public PaymentServiceImpl(KafkaTemplate<String, Payment> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void sendPayment(Payment payment) {
		logger.info(String.format("PAYMENT_SERVICE ::: Recebi o pagamento %s", payment.getId()));
		
		try {
			logger.info("PAYMENT_SERVICE ::: Simulando processamento do pagamento...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("PAYMENT_SERVICE ::: Enviando o pagamento para fila...");
		kafkaTemplate.send(TOPICS.PAYMENT, payment);
		
	}

}
