package com.towery.confignacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: 刘
 * @date: 2023年02月15日 下午 2:49
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${user.name}")
    private String name;
    @RequestMapping("/show")
    public String show(){
        return name;
    }
}
