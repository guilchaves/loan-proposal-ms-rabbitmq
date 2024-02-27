package br.com.guilchaves.creditanalysis.services.strategy;

import br.com.guilchaves.creditanalysis.domain.Proposal;

public interface InternalScoreCalculation {

    int calculate(Proposal proposal);
}
