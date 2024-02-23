package br.com.guilchaves.creditofferapp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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

    @Bean
    public FanoutExchange createFanoutExchangeProposalPending(){
        return ExchangeBuilder.fanoutExchange("proposal-pending.ex").build();
    }

    @Bean
    public Binding createBindingProposalPendingMsCreditAnalysis(){
        return BindingBuilder.bind(createQueueProposalPendingMsCreditAnalysis())
                .to(createFanoutExchangeProposalPending());
    }

    @Bean
    public Binding createBindingProposalPendingMsNotification(){
        return BindingBuilder.bind(createQueueProposalPendingMsNotification())
                .to(createFanoutExchangeProposalPending());
    }

    @Bean
    public MessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
