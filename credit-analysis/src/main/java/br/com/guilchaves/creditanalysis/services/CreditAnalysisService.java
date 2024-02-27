package br.com.guilchaves.creditanalysis.services;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import br.com.guilchaves.creditanalysis.services.strategy.InternalScoreCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    @Autowired
    private List<InternalScoreCalculation> calculateScoreList;

    public void analyze(Proposal proposal) {
        int score = calculateScoreList.stream().mapToInt(impl -> impl.calculate(proposal)).sum();
    }

}
