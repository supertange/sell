package com.supertange.sell.repository;

import com.supertange.sell.dataObject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategaryRespositoryTest {

    @Autowired
    private ProductCategoryRepository productCategaryRespository;
    @Test
    public  void findOneTest(){
        ProductCategory productCategory=productCategaryRespository.findOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryId(13);
        productCategory.setCategoryName("dsaf");
        productCategory.setCategoryType(3);
        productCategaryRespository.save(productCategory);
    }
    @Test
    public void updateOne(){
        ProductCategory productCategory=productCategaryRespository.findOne(1);
        productCategory.setCategoryType(4);
        productCategaryRespository.save(productCategory);
    }
    @Test
    @Transactional
    public void saveTest2(){
        ProductCategory productCategory=new ProductCategory("hahah",2);
        productCategaryRespository.save(productCategory);

    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list= Arrays.asList(1);
//        List<ProductCategory> result=productCategaryRespository.findByCategoryTypeIn(list);
//        log.error(String.valueOf(list.size()));
    }

}