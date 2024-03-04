package com.bitlord.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;


@RestController
public class CircuitBreakerController {


	// Define Log
	private Logger logger= LoggerFactory.getLogger( CircuitBreakerController.class );


	@GetMapping( "/sample-api" )
	//@Retry ( name = "sample-api", fallbackMethod = "hardcodedRespones" ) // add retry config
	//@CircuitBreaker ( name = "default", fallbackMethod = "hardcodedRespones" ) // add Circuit Breaker config
	//@RateLimiter( name = "default" ) // 10s  => 2 calls to the sample API
	@Bulkhead ( name = "default" )
	public String sampleApi() {

		// Get Log for output
		//logger.info( "Sample API call received" );
		//ResponseEntity<String> forEntity = new RestTemplate().getForEntity( "http://localhost:8080/some-dummy-url", String.class ); // set dummy url (this not work)
		//return forEntity.getBody();

		return "sample-api";
	}



	public String hardcodedRespones( Exception ex ) { // fall back method

		return "fallback-response";

	}


}
