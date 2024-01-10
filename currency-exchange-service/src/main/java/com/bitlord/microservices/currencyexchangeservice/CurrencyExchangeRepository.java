package com.bitlord.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface CurrencyExchangeRepository extends JpaRepository < CurrencyExchange , Long > {
	
	CurrencyExchange findByFromAndTo ( String from, String to );
	
}
