package com.xmg.service;

import com.xmg.remoteApi.PermissionApi;
import com.xmg.support.Permission;
import com.xmg.support.Role;
import com.xmg.support.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xmg.server.support.annotation.RpcProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RpcProvider
@RequiredArgsConstructor
public class UserService {
    private static final Map<String, User> userMap = new HashMap<>();
    private final PermissionApi permissionApi;

    static {
        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role("role","roleInfo"));
        final User user0 = new User("laoWang", "13300000000");
        user0.setRoles(roleList);
        final User user1 = new User("laoZhang", "13400000000");
        user0.setRoles(roleList);
        final User user2 = new User("laoLi", "13500000000");
        userMap.put("laoWang", user0);
        userMap.put("laoZhang", user1);
        userMap.put("laoLi", user2);
    }

    public User userInfo(String username) {
        final User user = userMap.get(username);
        final Permission permission = permissionApi.permission(username);
        user.setPermission(permission);
        return user;
    }

    public void addUser(String username,String phone){
        int i= 100/0;
        userMap.put(username,new User(username, phone));
    }
}
