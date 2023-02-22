package com.tulingxueyuan.stock.controller;

import com.tulingxueyuan.stock.service.StockService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping("/reduct")
    public String reduct(@RequestParam(value="productId") Integer productId){
        stockService.reduct(productId);
        return "扣减库存";
    }

}
