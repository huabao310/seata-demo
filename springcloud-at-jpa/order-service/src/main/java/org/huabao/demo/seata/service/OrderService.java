package org.huabao.demo.seata.service;

import org.huabao.demo.seata.entity.Order;
import org.huabao.demo.seata.feign.UserFeignClient;
import org.huabao.demo.seata.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Yang.Yao5
 * 2020/12/10 11:07
 */
@Service
public class OrderService {
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private OrderDAO orderDAO;

    @Transactional(rollbackFor = Exception.class)
    public void create(String userId,String commodityCode, Integer count){
        // 单价 8
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(8));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDAO.save(order);
        userFeignClient.debit(userId, orderMoney);
    }
}
