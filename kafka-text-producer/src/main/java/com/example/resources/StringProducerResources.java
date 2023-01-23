package com.example.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.StringProducerService;

@RestController
@RequestMapping("/producer")
public class StringProducerResources {

	private final StringProducerService stringProducerService;
	
	@Autowired
	public StringProducerResources(StringProducerService stringProducerService) {
		super();
		this.stringProducerService = stringProducerService;
	}

	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody String message) {
		stringProducerService.sendMessage(message);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
