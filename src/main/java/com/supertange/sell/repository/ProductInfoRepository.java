package com.supertange.sell.repository;

import com.supertange.sell.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatusIn(Integer productStatus);

}
