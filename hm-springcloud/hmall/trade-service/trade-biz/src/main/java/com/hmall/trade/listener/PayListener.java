package com.hmall.trade.listener;

import com.hmall.trade.domain.po.Order;
import com.hmall.trade.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class PayListener {

    private final IOrderService orderService;
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "trade.pay.success.queue",arguments = @Argument( name = "x-queue-mode", value = "lazy")),
            exchange = @Exchange(name = "pay.direct",type = ExchangeTypes.DIRECT),
            key = {"pay.success"}
    ))
    public void paySuccess(Message message){
        String ID = new String(message.getBody());
        Order order = orderService.getById(Long.valueOf(ID));

        if(order == null || order.getStatus() != 1){
            return;
        }

        orderService.markOrderPaySuccess(Long.valueOf(ID));
        System.out.println("ID:"+message.getMessageProperties().getMessageId());
//        throw new RuntimeException("测试异常");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "DLX.queue"),
            exchange = @Exchange(name = "DLX.direct",type = ExchangeTypes.DIRECT),
            key = {"delay"}
    ))
    public void DLXTest(Message message){
        System.out.println("DLX:" + new String(message.getBody()));
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "delay.queue"),
            exchange = @Exchange(name = "delay.direct",type = ExchangeTypes.DIRECT, delayed = "true"),
            key = {"delay"}
    ))
    public void DelayTest(Message message){
        System.out.println("Delay插件:" + new String(message.getBody()));
    }
}
