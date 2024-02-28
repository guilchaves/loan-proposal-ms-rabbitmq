package br.com.guilchaves.creditanalysis.services;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import br.com.guilchaves.creditanalysis.services.strategy.InternalScoreCalculation;
import br.com.guilchaves.creditanalysis.services.strategy.exceptions.StrategyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    @Autowired
    private List<InternalScoreCalculation> calculateScoreList;

    @Autowired
    private NotificationRabbitMQService notificationRabbitMQService;

    @Autowired
    @Value("${rabbitmq.proposalcompleted.exchange}")
    private String exchangeProposalCompleted;

    public void analyze(Proposal proposal) {
        try {
            boolean approved = calculateScoreList.stream().mapToInt(impl -> impl.calculate(proposal)).sum() > 350;
            proposal.setApproved(approved);
        } catch (StrategyException e) {
            proposal.setApproved(false);
            proposal.setObservation(e.getMessage());
        }

        notificationRabbitMQService.sendNotification(exchangeProposalCompleted, proposal);
    }

}
