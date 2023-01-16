package com.xmg.api.account;

/**
 * @author makui
 * @created 2023/1/16
 **/
public interface AccountOpenApi {
    void deductBalance(Long accountId, Double amount);
}
