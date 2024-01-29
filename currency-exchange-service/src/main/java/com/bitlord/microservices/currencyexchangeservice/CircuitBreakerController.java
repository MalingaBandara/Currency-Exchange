package com.bitlord.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;


@RestController
public class CircuitBreakerController {
	
	
	// Define Log
	private Logger logger= LoggerFactory.getLogger( CircuitBreakerController.class );
	
	
	@GetMapping( "/sample-api" )
	@Retry ( name = "sample-api", fallbackMethod = "hardcodedRespones" ) // add retry config 
	public String sampleApi() {
		
		// Get Log for output 
		logger.info( "Sample API call received" );
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity( "http://localhost:8080/some-dummy-url", String.class ); // set dummy url (this not work)
		
		return forEntity.getBody();
		
	}
	
	
	
	public String hardcodedRespones( Exception ex ) { // fall back method
		
		return "fallback-response";
		
	}
		

}
 