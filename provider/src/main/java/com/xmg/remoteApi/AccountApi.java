package com.xmg.remoteApi;

import xmg.client.support.RpcApi;

/**
 * @author makui
 * @created on  2022/4/5
 **/
@RpcApi(value = "account")
public interface AccountApi {
    void deductBalance(Long accountId, Double amount);
}
