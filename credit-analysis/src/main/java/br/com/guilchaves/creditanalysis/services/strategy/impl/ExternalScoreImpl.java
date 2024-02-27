package br.com.guilchaves.creditanalysis.services.strategy.impl;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import br.com.guilchaves.creditanalysis.services.strategy.InternalScoreCalculation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class ExternalScoreImpl implements InternalScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        int clientCreditScore = score();

        if (clientCreditScore <= 200){
            throw new RuntimeException("Insuficient score for credit");
        }

        int internalScore;
        if (clientCreditScore <= 400){
            internalScore = 150;
        } else if (clientCreditScore <= 600){
            internalScore = 180;
        } else {
            internalScore = 220;
        }

        return internalScore;
    }

    /**
     * Mocks a credit score external api request
     * @return int
     */
    private int score() {
        return new Random().nextInt(0, 1000);
    }
}
