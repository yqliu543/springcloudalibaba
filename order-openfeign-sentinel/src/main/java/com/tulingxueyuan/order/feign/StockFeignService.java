package com.tulingxueyuan.order.feign;

import com.tulingxueyuan.order.feign.iml.StockFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service",path = "/stock",fallback = StockFeignServiceFallback.class)
public interface StockFeignService {
    @RequestMapping("/reduct2")
    public String reduct2();

}
