package br.com.guilchaves.loanproposal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LoanProposalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanProposalApplication.class, args);
	}

}
