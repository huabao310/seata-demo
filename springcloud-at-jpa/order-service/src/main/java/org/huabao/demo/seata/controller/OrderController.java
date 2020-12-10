package org.huabao.demo.seata.controller;

import org.huabao.demo.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang.Yao5
 * 2020/12/10 14:22
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public Boolean create(String userId,String commodityCode, Integer count){
        orderService.create(userId, commodityCode, count);
        return true;
    }
}
