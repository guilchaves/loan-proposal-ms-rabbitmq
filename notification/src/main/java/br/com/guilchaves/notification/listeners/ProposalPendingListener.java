package br.com.guilchaves.notification.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ProposalPendingListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
    public void proposalPending(){}
}
