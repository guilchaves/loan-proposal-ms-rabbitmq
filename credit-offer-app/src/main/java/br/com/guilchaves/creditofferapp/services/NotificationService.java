package br.com.guilchaves.creditofferapp.services;

import br.com.guilchaves.creditofferapp.dto.ProposalResponseDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notifiy(ProposalResponseDTO proposal, String exchange){
        rabbitTemplate.convertAndSend(exchange, "", proposal);
    }
}
