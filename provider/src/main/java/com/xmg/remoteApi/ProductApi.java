package com.xmg.remoteApi;

import com.xmg.entity.Product;
import io.seata.core.context.RootContext;
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
public class ProductApi {
    private final EntityManager entityManager;

    public ProductApi(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void reduceCount(Long id, Long count) {
        final String xid = RootContext.getXID();
        System.out.println("xid:" + xid);
        final Product product = entityManager.find(Product.class, id);
        Assert.state(product.getCount() > count, "库存不足");
        product.setCount(product.getCount() - count);
        entityManager.merge(product);
    }
}
