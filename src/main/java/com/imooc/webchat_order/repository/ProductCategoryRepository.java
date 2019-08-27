package com.imooc.webchat_order.repository;

import com.imooc.webchat_order.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

    //根据多个Type得到category
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
}