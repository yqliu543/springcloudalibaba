package com.tulingxueyuan.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:
 * @author: 刘
 * @date: 2023年02月06日 下午 4:23
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/{id}")
    public String get(@PathVariable Integer id){
        System.out.println("查询商品："+id);
        return "查询商品_"+id+",端口"+port;
    }
}
