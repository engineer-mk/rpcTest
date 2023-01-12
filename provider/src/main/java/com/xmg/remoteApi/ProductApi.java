package com.xmg.remoteApi;

import com.xmg.entity.Product;
import com.xmg.repository.ProductRepository;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import xmg.server.support.annotation.RpcProvider;

import javax.persistence.EntityManager;

/**
 * @author makui
 * @created 2022/4/2
 **/
@RpcProvider
@Service
@RequiredArgsConstructor
public class ProductApi {
    private final ProductRepository productRepository;
    private final AccountApi accountApi;
    private final EntityManager entityManager;

    public void reduceCount(Long id, Long count) {
        final String xid = RootContext.getXID();
        System.out.println("xid:" + xid);
        final Product product = entityManager.find(Product.class,id);
        Assert.state(product.getCount() > count, "库存不足");
        product.setCount(product.getCount() - count);
        productRepository.save(product);
        accountApi.deductBalance(1L, 10d * count);
    }
}
