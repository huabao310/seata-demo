package org.huabao.demo.seata.controller;

import org.huabao.demo.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Yang.Yao5
 * 2020/12/10 14:03
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/debit")
    public Boolean debit(String userId, BigDecimal money){
        accountService.debit(userId, money);

        return true;
    }
}
