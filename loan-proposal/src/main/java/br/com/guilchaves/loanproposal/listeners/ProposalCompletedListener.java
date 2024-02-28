package br.com.guilchaves.loanproposal.listeners;

import br.com.guilchaves.loanproposal.entities.Proposal;
import br.com.guilchaves.loanproposal.repositories.ProposalRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalCompletedListener {

    @Autowired
    private ProposalRepository proposalRepository;

    @RabbitListener(queues = "${rabbitmq.queue.proposal.completed}")
    public void proposalCompleted(Proposal proposal){
        proposalRepository.save(proposal);
    }

}
