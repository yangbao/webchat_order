package com.imooc.webchat_order.controller;

import com.imooc.webchat_order.dataobject.ProductCategory;
import com.imooc.webchat_order.dataobject.ProductInfo;
import com.imooc.webchat_order.service.CategoryService;
import com.imooc.webchat_order.service.ProductService;
import com.imooc.webchat_order.utils.ResultVOUtil;
import com.imooc.webchat_order.vo.ProductInfoVO;
import com.imooc.webchat_order.vo.ProductVO;
import com.imooc.webchat_order.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品列表-GET /sell/buyer/product/list
 * 参数 - 无
 * 返回:
 *
 {
 "code": 0,
 "msg": "成功",
 "data": [
     {
         "name": "热榜",
         "type": 1,
         "foods": [
             {
             "id": "123456",
             "name": "皮蛋粥",
             "price": 1.2,
             "description": "好吃的皮蛋粥",
             "icon": "http://xxx.com",
             }
        ]
     },
     {
         "name": "好吃的",
         "type": 2,
         "foods": [
             {
             "id": "123457",
             "name": "慕斯蛋糕",
             "price": 10.9,
             "description": "美味爽口",
             "icon": "http://xxx.com",
             }
        ]
     }
    ]
 }
 */
@RestController()
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ResultVO list() {
//1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}














