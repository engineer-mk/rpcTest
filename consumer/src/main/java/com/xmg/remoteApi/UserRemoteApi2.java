package com.xmg.remoteApi;

import com.xmg.support.User;
import xmg.client.support.RpcApi;

//@RpcApi(url = "127.0.0.1:7002")
public interface UserRemoteApi2 {
    User userInfo(String username);

    void addUser(String username, String phone);
}
