package com.xmg.support;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = 23513597551L;

    private String permission;

    public Permission(String permission) {
        this.permission = permission;
    }
}
