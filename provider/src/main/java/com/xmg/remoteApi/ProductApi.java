package com.xmg.remoteApi;

import com.xmg.entity.Product;
import com.xmg.repository.ProductRepository;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import xmg.server.support.annotation.RpcProvider;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

/**
 * @author makui
 * @created 2022/4/2
 **/
@RpcProvider
@Service
public class ProductApi {
    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private  AccountApi accountApi;
    @Autowired
    private  EntityManager entityManager;
    @Autowired
    @Lazy
    private  ProductApi productApi;

    public void  reduceCount(Long id, Long count){
        productApi.doReduceCount(id, count);
        accountApi.deductBalance(1L, 10d * count);
    }

    @Transactional
    public void doReduceCount(Long id, Long count) {
        final String xid = RootContext.getXID();
        System.out.println("xid:" + xid);
        final Product product = entityManager.find(Product.class,id,LockModeType.PESSIMISTIC_WRITE);
        Assert.state(product.getCount() > count, "库存不足");
        product.setCount(product.getCount() - count);
        productRepository.save(product);
    }
}
