package com.xmg.remoteApi;

import com.xmg.support.Permission;
import xmg.client.support.RpcApi;

//@RpcApi("provider3")
@RpcApi(url = "127.0.0.1:7006",trace = "false")
public interface PermissionApi {
    Permission permission(String username);
}
