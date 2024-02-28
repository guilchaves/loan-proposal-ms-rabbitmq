package br.com.guilchaves.creditanalysis.listeners;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import br.com.guilchaves.creditanalysis.services.CreditAnalysisService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProposalReviewListener {

    @Autowired
    private CreditAnalysisService creditAnalysisService;

    @RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
    public void reviewProposal(Proposal proposal){
        creditAnalysisService.analyze(proposal);
    }
}
