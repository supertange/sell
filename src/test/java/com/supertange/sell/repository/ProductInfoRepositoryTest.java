package com.supertange.sell.repository;

import com.supertange.sell.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setCategoryType(1);
        productInfo.setProductName("fa");
        productInfo.setProductPrice(BigDecimal.valueOf(12));
        productInfo.setProductId(String.valueOf(123));
        productInfo.setProductStock(123);
        productInfo.setProductStatus(0);
        productInfoRepository.save(productInfo);
    }
    @Test
    public void query(){
        productInfoRepository.findByProductStatusIn(0);
    }
    @Test
    public void findByProductStatus(){
        List<ProductInfo> productInfoList=productInfoRepository.findByProductStatusIn(0);
        Assert.assertNotEquals(2,productInfoList.size());
    }

}