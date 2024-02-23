package br.com.guilchaves.creditofferapp.config;

import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;


@Configuration
public class RabbitMQConfiguration {

    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    //Todo
    // extract create queue methods to corresponding microservices
    @Bean
    public Queue createQueueProposalPendingMsCreditAnalysis(){
        return QueueBuilder.durable("proposal-pending.ms-credit-analysis").build();
    }

    @Bean
    public Queue createQueueProposalPendingMsNotification(){
        return QueueBuilder.durable("proposal-pending.ms-notification").build();
    }

    @Bean
    public Queue createQueueProposalFinishedMsProposal(){
        return QueueBuilder.durable("proposal-finished.ms-proposal").build();
    }

    @Bean
    public Queue createQueueProposalFinishedMsNotification(){
        return QueueBuilder.durable("proposal-finished.ms-notification").build();
    }


}
