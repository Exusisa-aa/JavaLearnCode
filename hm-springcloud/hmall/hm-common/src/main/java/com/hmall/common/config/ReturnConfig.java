package com.hmall.common.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@RequiredArgsConstructor
@ConditionalOnClass(DispatcherServlet.class)
public class ReturnConfig {

    private final RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.setReturnsCallback(returned -> {
            log.error("消息发送失败");
            log.debug("exchange: {}",returned.getExchange());
            log.debug("routingKey: {}",returned.getRoutingKey());
            log.debug("message: {}",returned.getMessage());
            log.debug("replyCode: {}",returned.getReplyCode());
            log.debug("replyText: {}",returned.getReplyText());
        });
    }
}
