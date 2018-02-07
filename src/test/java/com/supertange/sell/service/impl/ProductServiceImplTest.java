package com.supertange.sell.service.impl;

import com.supertange.sell.dataObject.ProductInfo;
import com.supertange.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productServiceIml;

    @Test
    public void findOne() {
        ProductInfo productInfo=productServiceIml.findOne("123");
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfo=productServiceIml.findUpAll();
        Assert.assertEquals(1,productInfo.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<ProductInfo> productInfos=productServiceIml.findAll(pageRequest);
//        System.out.println(productInfos.getTotalElements());
        Assert.assertEquals(1,productInfos.getTotalPages());
    }

    @Test
    public void save() {
    }
}