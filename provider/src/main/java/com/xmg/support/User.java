package com.xmg.support;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private String username;
    private String phone;
    private List<Role> roles;
    private Permission permission;

    public User(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }
}
