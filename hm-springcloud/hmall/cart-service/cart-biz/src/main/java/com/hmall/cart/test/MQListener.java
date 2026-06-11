package com.hmall.cart.test;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MQListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "fanout.queue1" ),
            exchange = @Exchange(name = "hmall.fanout", type = ExchangeTypes.FANOUT)
    ))
    public void listenQueue1(String message){
        System.out.println("消费者1：-------------------------"+message+"-------------------------");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "fanout.queue2" ),
            exchange = @Exchange(name = "hmall.fanout", type = ExchangeTypes.FANOUT)
    ))
    public void listenQueue2(String message){
        System.out.println("消费者2：-------------------------"+message+"-------------------------");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue3" ),
            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
            key = {"confirm","cancel"}
    ))
    public void listenQueue3(String message){
        System.out.println("消费者3：-------------------------"+message+"-------------------------");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue4" ),
            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
            key = {"confirm","routing"}
    ))
    public void listenQueue4(String message){
        System.out.println("消费者4：-------------------------"+message+"-------------------------");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue5" ),
            exchange = @Exchange(name = "hmall.topic", type = ExchangeTypes.TOPIC),
            key = {"china.#"}
    ))
    public void listenQueue5(String message){
        System.out.println("消费者5：-------------------------"+message+"-------------------------");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue6" ),
            exchange = @Exchange(name = "hmall.topic", type = ExchangeTypes.TOPIC),
            key = {"#.news"}
    ))
    public void listenQueue6(String message){
        System.out.println("消费者6：-------------------------"+message+"-------------------------");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "object.queue" ),
            exchange = @Exchange(name = "hmall.object", type = ExchangeTypes.DIRECT),
            key = {"object"}
    ))
    public void listenQueue(Map<String,Object> message){
        System.out.println("消费者：-------------------------"+message+"-------------------------");
    }
}
