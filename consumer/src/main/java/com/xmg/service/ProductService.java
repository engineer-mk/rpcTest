package com.xmg.service;

import com.xmg.remoteApi.ProductApi;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author makui
 * @created on  2022/4/5
 **/
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductApi productApi;
    private final OrderService orderService;

    @GlobalTransactional(rollbackFor = Exception.class)
    public void placeOrder(Long productId, Long count) {
        orderService.placeOrder(productId, count);
        productApi.reduceCount(productId, count);
    }
}
