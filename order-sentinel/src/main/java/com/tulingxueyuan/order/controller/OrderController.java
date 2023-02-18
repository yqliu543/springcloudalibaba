package com.tulingxueyuan.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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

    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功！");
        return "Hello World---";
    }
    @RequestMapping("/flow")
    @SentinelResource(value = "flow",blockHandler = "blockHandlerflow")
    public String flow(){
        return "Hello World---";
    }
    public String blockHandlerflow(BlockException e){
        return "已被流控";
    }

}
