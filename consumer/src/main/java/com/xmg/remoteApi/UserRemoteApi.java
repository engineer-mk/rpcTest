package com.xmg.remoteApi;

import com.xmg.support.User;
import xmg.client.support.RpcApi;

//@RpcApi(value = "provider",trace = true)
@RpcApi(url = "127.0.0.1:7001",trace = "true")
public interface UserRemoteApi {
    User userInfo(String username);

    void addUser(String username, String phone);
}
