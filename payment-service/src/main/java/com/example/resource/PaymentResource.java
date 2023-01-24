package com.example.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Payment;

public interface PaymentResource {
	
	@PostMapping
	public ResponseEntity<Payment> sendPayment(@RequestBody Payment payment);

}
