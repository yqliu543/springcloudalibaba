package com.tulingxueyuan.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:
 * @author: 刘
 * @date: 2023年02月06日 下午 4:23
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Value("${server.port}")
    String port;
    @RequestMapping("/reduct")
    public String reduct(){
        System.out.println("扣减成功");
        return "扣减成功-2_"+port;
    }
}
