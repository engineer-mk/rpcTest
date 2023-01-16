package com.xmg.remoteApi;

import com.xmg.api.account.AccountOpenApi;
import xmg.client.support.RpcApi;

/**
 * @author makui
 * @created on  2022/4/5
 **/
@RpcApi(value = "account")
public interface AccountApi extends AccountOpenApi {
}
