package com.xmg.support;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Permission {
    private String permission;

    public Permission(String permission) {
        this.permission = permission;
    }
}
