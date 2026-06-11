package com.hmall.item.api.fallback;


import com.hmall.common.utils.CollUtils;
import com.hmall.item.api.ItemClient;
import com.hmall.item.dto.ItemDTO;
import com.hmall.trade.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class ItemClientFallbackFactory implements FallbackFactory<ItemClient> {
    @Override
    public ItemClient create(Throwable cause) {
        return new ItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(Collection<Long> itemIds) {
                return CollUtils.emptyList();
            }

            @Override
            public void deductStock(List<OrderDetailDTO> items) {
                throw  new RuntimeException(cause);
            }

            @Override
            public void insertItem(Map<Long, Integer> items) {
                throw  new RuntimeException(cause);
            }
        };
    }
}
