package com.xmg.remoteApi;

import com.xmg.api.account.AccountOpenApi;
import com.xmg.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import xmg.server.support.annotation.RpcProvider;

import javax.persistence.EntityManager;

/**
 * @author makui
 * @created on  2022/4/5
 **/
@RpcProvider
@Service
public class AccountOpenApiImpl implements AccountOpenApi {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    @Lazy
    private AccountOpenApiImpl accountOpenApi;

    public void deductBalance(Long accountId, Double amount) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        accountOpenApi.doDeductBalance(accountId, amount);
    }

    @Transactional
    public void doDeductBalance(Long accountId, Double amount) {
        final Account account = entityManager.find(Account.class, accountId);
        Assert.state(account.getBalance() >= amount, "余额不足");
        account.setBalance(account.getBalance() - amount);
        entityManager.merge(account);
    }
}
