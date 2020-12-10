package org.huabao.demo.seata.controller;

import org.huabao.demo.seata.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang.Yao5
 * 2020/12/10 11:07
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping(path = "/deduct")
    public Boolean deduct(String commodityCode, Integer count) {
        storageService.deduct(commodityCode, count);
        return true;
    }
}
