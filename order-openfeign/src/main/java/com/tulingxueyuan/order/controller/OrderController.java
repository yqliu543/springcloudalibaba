package com.tulingxueyuan.order.controller;

import com.tulingxueyuan.order.feign.ProductFeignService;
import com.tulingxueyuan.order.feign.StockFeignService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @author: 刘
 * @date: 2023年02月06日 下午 4:15
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    StockFeignService stockFeignService;
    @Autowired
    ProductFeignService productFeignService;
    @RequestMapping("/add")
    public String add(){
        String msg = stockFeignService.reduct();
        String p = productFeignService.get(1);
        System.out.println("下单成功");
        return "Hello OpenFeign~~~"+msg+"---"+p;
    }

}
