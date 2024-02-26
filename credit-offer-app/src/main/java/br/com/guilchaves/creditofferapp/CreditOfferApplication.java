package br.com.guilchaves.creditofferapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CreditOfferApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditOfferApplication.class, args);
	}

}
