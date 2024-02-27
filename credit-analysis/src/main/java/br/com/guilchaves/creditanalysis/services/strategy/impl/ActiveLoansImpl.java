package br.com.guilchaves.creditanalysis.services.strategy.impl;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import br.com.guilchaves.creditanalysis.services.strategy.InternalScoreCalculation;

import java.util.Random;

public class ActiveLoansImpl implements InternalScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return activeLoans() ? 0 : 80;
    }

    /**
     * Mocks an external api request to check if client have active loans
     * @return boolean
     */
    private boolean activeLoans(){
        return new Random().nextBoolean();
    }
}
