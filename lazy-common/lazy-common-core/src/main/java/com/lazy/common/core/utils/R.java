package com.lazy.common.core.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public static R success() {
        return R.builder()
                .success(true)
                .code(RCodeEnum.SUCCESS.getCode())
                .message(RCodeEnum.SUCCESS.getMessage())
                .build();
    }

    public static R error() {
        return R.builder()
                .success(false)
                .code(RCodeEnum.ERROR.getCode())
                .message(RCodeEnum.ERROR.getMessage())
                .build();
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R data(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        this.setData(map);
        return this;
    }

    public R data(Map<String, Object> data) {
        this.setData(data);
        return this;
    }
}
