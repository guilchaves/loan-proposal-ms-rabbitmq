package br.com.guilchaves.notification.listeners;

import br.com.guilchaves.notification.constants.Message;
import br.com.guilchaves.notification.domain.Proposal;
import br.com.guilchaves.notification.services.NotificationSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalCompletedListener {

    @Autowired
    private NotificationSnsService notificationSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposal.completed}")
    public void proposalCompleted(Proposal proposal){
        if (proposal.getApproved()){
            String message = String.format(Message.PROPOSAL_APPROVED, proposal.getUser().getName());
            notificationSnsService.sendNotification(proposal.getUser().getPhone(), message);
        } else {
            String message = String.format(Message.PROPOSAL_DENIED, proposal.getUser().getName(), proposal.getObservation());
            notificationSnsService.sendNotification(proposal.getUser().getPhone(), message);
        }

    }
}
