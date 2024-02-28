package br.com.guilchaves.loanproposal.listeners;

import br.com.guilchaves.loanproposal.dto.ProposalResponseDTO;
import br.com.guilchaves.loanproposal.entities.Proposal;
import br.com.guilchaves.loanproposal.mappers.ProposalMapper;
import br.com.guilchaves.loanproposal.repositories.ProposalRepository;
import br.com.guilchaves.loanproposal.services.WebSocketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalCompletedListener {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private WebSocketService webSocketService;

    @RabbitListener(queues = "${rabbitmq.queue.proposal.completed}")
    public void proposalCompleted(Proposal proposal){
        proposalRepository.save(proposal);
        ProposalResponseDTO responseDTO = ProposalMapper.INSTANCE.convertEntityToDto(proposal);
        webSocketService.sendNotification(responseDTO);
    }

}
