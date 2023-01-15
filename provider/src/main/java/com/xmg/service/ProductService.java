package com.xmg.service;

import com.xmg.entity.Product;
import com.xmg.repository.ProductRepository;
import io.seata.rm.datasource.exec.LockConflictException;
import io.seata.rm.datasource.exec.LockWaitTimeoutException;
import io.seata.spring.annotation.GlobalLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PessimisticLockException;
import java.util.concurrent.TimeUnit;

/**
 * @author makui
 * @created on  2022/10/12
 **/
@Service
public class ProductService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    @Lazy
    private ProductService productService;

    /**
     * 分布式事物脏写问题
     * @param id
     * @param count
     */
    public void reduce(Long id, Long count) {
        try {
            productService.doReduce(id, count);
        } catch (LockConflictException | LockWaitTimeoutException | PessimisticLockException e) {
            System.out.println(e.getClass().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            reduce(id, count);
        }

    }

    @GlobalLock
    @Transactional
    public void doReduce(Long id, Long count) throws LockConflictException ,LockWaitTimeoutException, PessimisticLockException {
        final Product product = entityManager.find(Product.class, id);
        entityManager.lock(product, LockModeType.PESSIMISTIC_WRITE);
        Assert.state(product.getCount() > count, "库存不足");
        product.setCount(product.getCount() - count);
        productRepository.save(product);
    }

    @GlobalLock
    @Transactional
    public Product getProduct(Long id) {
        return entityManager.find(Product.class, id, LockModeType.PESSIMISTIC_WRITE);
    }
}
