package com.xmg.service;

import com.xmg.entity.ProductOrder;
import com.xmg.remoteApi.ProductApi;
import com.xmg.repository.ProductRepository;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author makui
 * @created 2022/4/2
 **/
@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    @Transactional
    public void placeOrder(Long productId,Long count){
        final ProductOrder order = new ProductOrder();
        order.setProductId(productId);
        entityManager.persist(order);
    }
}
