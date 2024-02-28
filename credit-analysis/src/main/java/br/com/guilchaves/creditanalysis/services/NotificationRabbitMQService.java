package br.com.guilchaves.creditanalysis.services;

import br.com.guilchaves.creditanalysis.domain.Proposal;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationRabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(String exhange, Proposal proposal) {
        rabbitTemplate.convertAndSend(exhange, "", proposal);

    }
}
