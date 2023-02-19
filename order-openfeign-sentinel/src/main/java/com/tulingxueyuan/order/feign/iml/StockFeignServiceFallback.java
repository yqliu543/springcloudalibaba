package com.tulingxueyuan.order.feign.iml;

import com.tulingxueyuan.order.feign.StockFeignService;
import org.springframework.stereotype.Component;

@Component
public class StockFeignServiceFallback implements StockFeignService {

    @Override
    public String reduct2() {
        return "降级了！！！";
    }
}
