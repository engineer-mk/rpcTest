package com.xmg.remoteApi;

import com.xmg.support.Permission;
import xmg.client.support.RpcApi;

//@RpcApi("provider2")
@RpcApi(url = "127.0.0.1:7005",trace = "true")
public interface PermissionApi {
    Permission permission(String username);
}
