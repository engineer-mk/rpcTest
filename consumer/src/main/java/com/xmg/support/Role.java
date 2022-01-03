package com.xmg.support;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role {
    private String name;
    private String info;

    public Role(String name, String info) {
        this.name = name;
        this.info = info;
    }
}
