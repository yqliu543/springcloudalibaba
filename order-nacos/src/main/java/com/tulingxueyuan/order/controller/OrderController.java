package com.tulingxueyuan.order.controller;

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
    private RestTemplate restTemplate;
    @RequestMapping("/add")
    public String add(){
        String msg = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        System.out.println("下单成功");

        return "Hello World---"+msg;
    }

}
