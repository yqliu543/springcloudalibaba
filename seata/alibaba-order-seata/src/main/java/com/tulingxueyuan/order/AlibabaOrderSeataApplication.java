package com.tulingxueyuan.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@SpringBootApplication
@EnableTransactionManagement     // 开启本地事务@Transactional
@EnableFeignClients
public class AlibabaOrderSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaOrderSeataApplication.class,args);
    }


}
