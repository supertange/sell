package com.supertange.sell.repository;

import com.supertange.sell.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(Collection<Integer> categoryTypeList);
}
