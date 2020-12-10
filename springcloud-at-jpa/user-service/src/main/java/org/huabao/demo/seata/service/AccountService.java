package org.huabao.demo.seata.service;

import org.huabao.demo.seata.entity.Account;
import org.huabao.demo.seata.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Yang.Yao5
 * 2020/12/10 11:07
 */
@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num){
        Account account = accountDAO.findByUserId(userId);
        BigDecimal currentMoney = account.getMoney().subtract(num);

        if (currentMoney.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("余额不足");
        } else {
            account.setMoney(currentMoney);
            accountDAO.save(account);
        }
    }
}
