package com.tulingxueyuan.config.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @author: 刘
 * @date: 2023年02月14日 上午 11:13
 */
@Configuration
public class RibbonRandomRuleConfig {
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
