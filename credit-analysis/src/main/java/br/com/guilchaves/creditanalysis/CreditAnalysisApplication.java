package br.com.guilchaves.creditanalysis;

import br.com.guilchaves.creditanalysis.services.CreditAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreditAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditAnalysisApplication.class, args);
	}


}
