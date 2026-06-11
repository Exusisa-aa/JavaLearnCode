package com.hmall.pay.api.fallback;

import com.hmall.pay.api.PayClient;
import com.hmall.pay.dto.PayOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

@Slf4j
public class PayClientFallback implements FallbackFactory<com.hmall.pay.api.PayClient> {
    @Override
    public PayClient create(Throwable cause) {
        return new PayClient() {
            @Override
            public PayOrderDTO queryPayOrderByBizOrderNo(Long id) {
                return null;
            }

            @Override
            public void delayPayOrder(Long id) {
                throw  new RuntimeException(cause);
            }
        };
    }
}