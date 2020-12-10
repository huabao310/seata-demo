package org.huabao.demo.seata.repository;

import org.huabao.demo.seata.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yang.Yao5
 * 2020/12/10 11:07
 */
public interface StorageDAO extends JpaRepository<Storage, String> {
    /**
     * 根据商品编号查找库存
     *
     * @param commodityCode 商品编号
     * @return 库存对象
     */
    Storage findByCommodityCode(String commodityCode);
}
