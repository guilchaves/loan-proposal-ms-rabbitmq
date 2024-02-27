package br.com.guilchaves.creditanalysis.listeners;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProposalReviewListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
    public void reviewProposal(Proposal proposal){

    }
}
