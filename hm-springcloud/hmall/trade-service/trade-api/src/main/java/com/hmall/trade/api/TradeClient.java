package com.hmall.trade.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@FeignClient("trade-service")
public interface TradeClient {

}
