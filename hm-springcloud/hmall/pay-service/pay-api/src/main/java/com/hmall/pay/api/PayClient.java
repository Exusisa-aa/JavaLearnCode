package com.hmall.pay.api;

import com.hmall.pay.api.fallback.PayClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "pay-service", fallbackFactory = PayClientFallback.class)
public interface PayClient {
    /**
     * 根据交易订单id查询支付单
     * @param id 业务订单id
     * @return 支付单信息
     */
    @GetMapping("/pay-orders/biz/{id}")
    com.hmall.pay.dto.PayOrderDTO queryPayOrderByBizOrderNo(@PathVariable("id") Long id);

    @PutMapping("/pay-orders/delay/{id}")
    void delayPayOrder(@PathVariable("id") Long id);
}