package com.tulingxueyuan.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @author: 刘
 * @date: 2023年02月15日 上午 11:06
 */
/*
全局配置加@Configuration
局部配置不加@Configuration
 */

@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignlevel(){
        return Logger.Level.FULL;
    }
}
