package com.ammdev.financialaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.ammdev.financialaggregator.external.client")
public class FinancialAggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialAggregatorApplication.class, args);
	}

}
