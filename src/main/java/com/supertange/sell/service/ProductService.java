package com.supertange.sell.service;

import com.supertange.sell.dataObject.ProductInfo;
import com.supertange.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询在架的所有商品
     * @return
     */
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
}
