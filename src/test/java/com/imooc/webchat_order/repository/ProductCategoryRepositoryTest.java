package com.imooc.webchat_order.repository;

import com.imooc.webchat_order.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void tetSave() {
        ProductCategory productCategory = new ProductCategory("男生最爱",1);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
//    @Transactional // 在测试里面用,会完全回滚不会影响数据库, 但是结果可以测试出来
    public void tetUpdate() {
        ProductCategory productCategory = repository.findOne(1);
        productCategory.setCategoryType(11);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void tetFindOne() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory);
    }
}