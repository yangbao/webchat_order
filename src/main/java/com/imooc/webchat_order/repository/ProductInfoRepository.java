package com.imooc.webchat_order.repository;

import com.imooc.webchat_order.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /*
    查询上架商品
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
