package com.xmg.remoteApi;

import com.xmg.support.Permission;
import xmg.client.support.RpcApi;

@RpcApi("provider2")
public interface PermissionApi {
    Permission permission(String username);
}
