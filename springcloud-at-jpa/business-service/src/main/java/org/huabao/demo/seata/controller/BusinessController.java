package org.huabao.demo.seata.controller;

import org.huabao.demo.seata.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/purchase")
    public Boolean purchase(String userId,String commodityCode, Integer orderCount){
        System.out.println("businessService " + businessService);

        businessService.purchase(userId, commodityCode,orderCount);
        return true;
    }
}
