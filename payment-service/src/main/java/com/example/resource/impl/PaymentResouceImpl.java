package com.example.resource.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Payment;
import com.example.resource.PaymentResource;
import com.example.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResouceImpl implements PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
	@Override
	public ResponseEntity<Payment> sendPayment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
