package org.huabao.demo.seata.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "storage_tbl")
@DynamicUpdate
@DynamicInsert
/**
 * @author Yang.Yao5
 * 2020/12/10 11:07
 */
public class Storage {
    @Id
    private Long id;
    private String commodityCode;
    private Integer count;

}
