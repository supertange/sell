package com.supertange.sell.service;

import com.supertange.sell.dataObject.ProductCategory;

import java.util.Collection;
import java.util.List;

public interface CategoryService {
    //根据id查询
    ProductCategory findOne(Integer categoryId);

    //查询所有
    List<ProductCategory> findAll();

    //通过类型查询
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //添加
    ProductCategory save(ProductCategory productCategory);


}
