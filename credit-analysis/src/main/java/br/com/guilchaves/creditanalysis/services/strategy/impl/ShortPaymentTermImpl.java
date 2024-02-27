package br.com.guilchaves.creditanalysis.services.strategy.impl;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import br.com.guilchaves.creditanalysis.services.strategy.InternalScoreCalculation;

public class ShortPaymentTermImpl implements InternalScoreCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return proposal.getLoanRepaymentTermMonths() < 120 ? 80 : 0;
    }

}
