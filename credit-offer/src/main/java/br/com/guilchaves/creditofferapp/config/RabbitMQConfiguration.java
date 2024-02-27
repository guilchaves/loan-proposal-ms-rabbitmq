package br.com.guilchaves.creditofferapp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.proposalpending.exchange}")
    private String exchangeProposalPending;

    @Value("${rabbitmq.proposalcompleted.exchange}")
    private String exchangeProposalCompleted;

    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange createFanoutExchangeProposalPending(){
        return ExchangeBuilder.fanoutExchange(exchangeProposalPending).build();
    }

    @Bean
    public FanoutExchange createFanoutExchangeProposalCompleted(){
        return ExchangeBuilder.fanoutExchange(exchangeProposalCompleted).build();
    }

    //Todo
    // extract create queue methods to corresponding microservices
    @Bean
    public Queue createQueueProposalPendingMSCreditAnalysis(){
        return QueueBuilder.durable("proposal-pending.ms-credit-analysis").build();
    }

    @Bean
    public Queue createQueueProposalPendingMSNotification(){
        return QueueBuilder.durable("proposal-pending.ms-notification").build();
    }

    @Bean
    public Queue createQueueProposalCompletedMSProposal(){
        return QueueBuilder.durable("proposal-completed.ms-proposal").build();
    }

    @Bean
    public Queue createQueueProposalCompletedMSNotification(){
        return QueueBuilder.durable("proposal-completed.ms-notification").build();
    }

    @Bean
    public Binding createBindingProposalPendingMSCreditAnalysis(){
        return BindingBuilder.bind(createQueueProposalPendingMSCreditAnalysis())
                .to(createFanoutExchangeProposalPending());
    }

    @Bean
    public Binding createBindingProposalPendingMSNotification(){
        return BindingBuilder.bind(createQueueProposalPendingMSNotification())
                .to(createFanoutExchangeProposalPending());
    }

    @Bean
    public Binding createBindingProposalCompletedMSProposalApp(){
        return BindingBuilder.bind(createQueueProposalCompletedMSProposal())
                .to(createFanoutExchangeProposalCompleted());
    }

    @Bean
    public Binding createBindingProposalCompletedMSNotification(){
        return BindingBuilder.bind(createQueueProposalCompletedMSNotification())
                .to(createFanoutExchangeProposalCompleted());
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
