package br.com.guilchaves.notification.listeners;

import br.com.guilchaves.notification.constants.Message;
import br.com.guilchaves.notification.domain.Proposal;
import br.com.guilchaves.notification.services.NotificationSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalPendingListener {

    @Autowired
    private NotificationSnsService  notificationSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
    public void proposalPending(Proposal proposal){
        String message = String.format(Message.PROPOSAL_UNDER_REVIEW, proposal.getUser().getName());
        notificationSnsService.sendNotification(proposal.getUser().getPhone(), message);
    }
}
