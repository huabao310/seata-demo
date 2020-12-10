package org.huabao.demo.seata.service;

import org.huabao.demo.seata.entity.Storage;
import org.huabao.demo.seata.repository.StorageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang.Yao5
 * 2020/12/10 11:07
 */
@Service
public class StorageService {
    @Autowired
    private StorageDAO storageDAO;

    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        Storage storage = storageDAO.findByCommodityCode(commodityCode);
        if (storage != null) {
            storage.setCount(storage.getCount() - count);
            storageDAO.save(storage);
        }
    }
}
