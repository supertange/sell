package com.supertange.sell.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    private  String productName;

    private BigDecimal productPrice;

    private  BigDecimal productStock;

    private String productDescription;

    private String productIcon;
    /**
     * status  状态
     * 0正常，1下架
     */
    private Integer productStatus;

    private Integer categoryType;


}
