package br.com.guilchaves.creditanalysis.services.strategy.impl;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import br.com.guilchaves.creditanalysis.services.strategy.InternalScoreCalculation;
import org.springframework.stereotype.Component;

@Component
public class IncomeExceedsRequestedAmountImpl implements InternalScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return incomeExceedsRequestedAmount(proposal) ? 100 : 0;
    }

    private boolean incomeExceedsRequestedAmount(Proposal proposal){
        return proposal.getUser().getIncome() > proposal.getRequestedAmount();
    }
}
