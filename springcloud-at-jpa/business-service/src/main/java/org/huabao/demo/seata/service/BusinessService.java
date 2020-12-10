package org.huabao.demo.seata.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.huabao.demo.seata.feign.OrderFeignClient;
import org.huabao.demo.seata.feign.StorageFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-05
 */
@Service
public class BusinessService {

    @Autowired
    private StorageFeignClient storageFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;

    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount){
        storageFeignClient.deduct(commodityCode, orderCount);

        orderFeignClient.create(userId, commodityCode, orderCount);
    }
}
