package com.xmg.controller;

import com.xmg.service.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final ProductService productService;


    @RequestMapping("/test3/{productId}/{count}")
    public void test3(@PathVariable Long count, @PathVariable Long productId) {
        productService.placeOrder(productId, count);
    }
}
