package com.xmg.remoteApi;

import com.xmg.api.product.ProductOpenApi;
import xmg.client.support.RpcApi;

/**
 * @author makui
 * @created 2022/4/2
 **/
@RpcApi(value = "product")
public interface ProductApi extends ProductOpenApi {
}
