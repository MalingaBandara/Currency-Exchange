package com.bitlord.microservices.currencyexchangeservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CircuitBreakerController {
	
	
	
	@GetMapping( "/sample-api" )
	public String sampleApi() {
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity( "http://localhost:8080/some-dummy-url", String.class ); // set dummy url (this not work)
		
		return forEntity.getBody();
		
	}
		

}
