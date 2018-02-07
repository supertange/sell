package com.supertange.sell.service.impl;

import com.supertange.sell.dataObject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory=categoryService.findOne(1);
        System.out.println(productCategory.toString());
//        Assert.assertNotEquals(new Integer(10),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByCategoryTypeIn() {
//            List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(Arrays.asList(1));
//            productCategoryList.toString();
    }

    @Test
    public void save() {
    }
}