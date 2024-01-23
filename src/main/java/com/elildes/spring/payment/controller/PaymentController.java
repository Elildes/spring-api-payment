package com.elildes.spring.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Value("${server.port}")
	private int serverPort;
	
	@GetMapping
    @NewSpan("rest-feign-payment")
	public ResponseEntity<String> listPays(){
		return ResponseEntity.ok("Payment success in " + serverPort);
	}
}
