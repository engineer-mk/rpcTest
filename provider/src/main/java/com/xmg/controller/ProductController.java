package com.xmg.controller;

import com.xmg.entity.Product;
import com.xmg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author makui
 * @created on  2022/10/12
 **/
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 分布式事物脏写问题
     * @param id
     * @param count
     */
    @RequestMapping("/product/{id}/{count}")
    public void reduce(@PathVariable Long count, @PathVariable Long id) {
        productService.reduce(id, count);
    }

    @RequestMapping("/product/get/{id}")
    public Product product(@PathVariable Long id){
        return productService.getProduct(id);
    }
}
