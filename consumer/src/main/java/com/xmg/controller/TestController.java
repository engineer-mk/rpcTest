package com.xmg.controller;

import com.xmg.remoteApi.UserRemoteApi;
import com.xmg.remoteApi.UserRemoteApi2;
import com.xmg.support.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserRemoteApi userRemoteApi;
//    private final UserRemoteApi2 userRemoteApi2;


    @RequestMapping("/test0")
    public void test0() {
        final User laoWang = userRemoteApi.userInfo("laoWang");
        System.out.println(laoWang.hashCode());
    }

    @RequestMapping("/test1")
    public void test1() {
        final User laoWang = userRemoteApi.userInfo("laoWang");
        System.out.println(laoWang.toString());
    }

    @RequestMapping("/test2")
    public void test2() {
        userRemoteApi.addUser("aaa", "bbb");
    }
}
