package br.com.guilchaves.loanproposal.services;

import br.com.guilchaves.loanproposal.dto.ProposalResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendNotification(ProposalResponseDTO proposal) {
        template.convertAndSend("/proposals", proposal);


    }

}
