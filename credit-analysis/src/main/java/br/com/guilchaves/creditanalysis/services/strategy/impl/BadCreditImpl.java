package br.com.guilchaves.creditanalysis.services.strategy.impl;

import br.com.guilchaves.creditanalysis.constants.Messages;
import br.com.guilchaves.creditanalysis.domain.Proposal;
import br.com.guilchaves.creditanalysis.services.strategy.InternalScoreCalculation;
import br.com.guilchaves.creditanalysis.services.strategy.exceptions.StrategyException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class BadCreditImpl implements InternalScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        if (badCredit()) {
            throw new StrategyException(String.format(Messages.CLIENT_BAD_CREDIT, proposal.getUser().getName()));
        }
        return 100;
    }

    /**
     * mocks a bad credit check external api request
     *
     * @return boolean
     */
    private boolean badCredit() {
        return new Random().nextBoolean();
    }
}
