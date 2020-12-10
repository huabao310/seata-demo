package org.huabao.demo.seata.repository;

import org.huabao.demo.seata.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yang.Yao5
 * 2020/12/10 14:22
 */
public interface OrderDAO extends JpaRepository<Order, String> {

}
