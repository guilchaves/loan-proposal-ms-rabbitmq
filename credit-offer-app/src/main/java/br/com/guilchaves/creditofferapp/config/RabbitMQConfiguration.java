package br.com.guilchaves.creditofferapp.config;

import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;


@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue createQueue(){
        return QueueBuilder.durable("").build();
    }

}
