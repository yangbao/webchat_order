package com.imooc.webchat_order.service;

import com.imooc.webchat_order.WebchatOrderApplicationTests;
import com.imooc.webchat_order.dataobject.ProductCategory;
import com.imooc.webchat_order.service.impl.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceTest extends WebchatOrderApplicationTests {
    @Autowired
    private CategoryService categoryService;
    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        System.out.println(productCategory);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        productCategoryList.forEach(productCategory -> System.out.println(productCategory));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(10,11));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("女生专享", 10);
        ProductCategory result = categoryService.save(productCategory);
        System.out.println(result);
        Assert.assertNotNull(result);
    }
}