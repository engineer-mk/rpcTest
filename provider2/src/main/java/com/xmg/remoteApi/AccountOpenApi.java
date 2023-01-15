package com.xmg.remoteApi;

import com.xmg.entity.Account;
import lombok.RequiredArgsConstructor;
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
public class AccountOpenApi {
    @Autowired
    private  EntityManager entityManager;
    @Autowired
    @Lazy
    private AccountOpenApi accountOpenApi;
    public void deductBalance(Long accountId, Double amount) {
        accountOpenApi.doDeductBalance(accountId, amount);
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int i = 10 / 0;
    }

    @Transactional
    public void doDeductBalance(Long accountId, Double amount) {
        final Account account = entityManager.find(Account.class, accountId);
        Assert.state(account.getBalance() >= amount, "余额不足");
        account.setBalance(account.getBalance() - amount);
        entityManager.merge(account);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int i = 10 / 0;
    }
}
