package com.towery.sentinel.pojo;

import lombok.Data;

@Data
public class User {
    private String name;

    public User(String zhangsan) {
        this.name=zhangsan;
        System.out.println(zhangsan);
    }

}
