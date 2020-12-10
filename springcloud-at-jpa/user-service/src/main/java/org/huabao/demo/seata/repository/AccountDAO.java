package org.huabao.demo.seata.repository;

import org.huabao.demo.seata.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yang.Yao5
 * 2020/12/10 14:03
 */
public interface AccountDAO extends JpaRepository<Account, String> {
    /**
     * 根据用户编号查询帐户
     * @param userId 用户编号
     * @return 帐户
     */
    Account findByUserId(String userId);
}
