package com.xmg.remoteApi;

import com.xmg.entity.Account;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AccountOpenApi {
    private final EntityManager entityManager;

    @Transactional
    public void deductBalance(Long accountId, Double amount){
        final Account account = entityManager.find(Account.class, accountId);
        Assert.state(account.getBalance()>=amount,"余额不足");
        account.setBalance(account.getBalance() - amount);
        entityManager.merge(account);
    }
}
