package com.dylee.mall.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN(1),
    CUSTUMER(0);

    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }
}
