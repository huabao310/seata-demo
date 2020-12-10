package org.huabao.demo.seata.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_tbl")
@DynamicUpdate
@DynamicInsert
/**
 * @author Yang.Yao5
 * 2020/12/10 14:22
 */
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String commodityCode;
    private BigDecimal money;
    private Integer count;

}
