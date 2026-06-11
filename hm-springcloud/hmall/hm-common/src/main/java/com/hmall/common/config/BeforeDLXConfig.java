package com.hmall.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@RequiredArgsConstructor
@ConditionalOnClass(DispatcherServlet.class)
public class BeforeDLXConfig {

    @Bean
    public DirectExchange beforeDLXExchange(){
        return ExchangeBuilder.directExchange("beforeDLX.direct").build();
    }

    @Bean
    public Queue beforeDLXQueue(){
        return QueueBuilder.durable("beforeDLX.queue").deadLetterExchange("DLX.direct").build();
    }

    @Bean
    public Binding beforeDLXBinding(Queue beforeDLXQueue, DirectExchange beforeDLXExchange){
        return BindingBuilder.bind(beforeDLXQueue).to(beforeDLXExchange).with("delay");
    }

}
