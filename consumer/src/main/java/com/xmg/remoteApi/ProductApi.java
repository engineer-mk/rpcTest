package com.xmg.remoteApi;

import xmg.client.support.RpcApi;

/**
 * @author makui
 * @created 2022/4/2
 **/
@RpcApi(value = "provider")
public interface ProductApi {
    void reduceCount(Long id, Long count);
}
