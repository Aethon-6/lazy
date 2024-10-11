package com.lazy.common.core.utils;

public enum RCodeEnum {
    SUCCESS(20000, "成功"),
    ERROR(20001, "失败");
    private final Integer code;
    private final String message;

    RCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
