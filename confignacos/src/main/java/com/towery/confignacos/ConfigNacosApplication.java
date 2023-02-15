package com.towery.confignacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigNacosApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigNacosApplication.class, args);
        String username = applicationContext.getEnvironment().getProperty("user.name");
        System.err.println("username:"+username);
    }

}
