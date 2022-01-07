package com.xmg.support;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 3253453234L;

    private String name;
    private String info;

    public Role(String name, String info) {
        this.name = name;
        this.info = info;
    }
}
