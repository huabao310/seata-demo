package org.huabao.demo.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
@FeignClient(name = "STORAGE-SERVICE", url = "127.0.0.1:18081")
public interface StorageFeignClient {

    @GetMapping("/deduct")
    void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);

}
