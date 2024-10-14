package com.lazy.common.core.enums;

import lombok.Getter;

@Getter
public enum RCodeEnum {
    SUCCESS(20000, "成功"),
    ERROR(20001, "失败");
    private final Integer code;
    private final String message;

    RCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
