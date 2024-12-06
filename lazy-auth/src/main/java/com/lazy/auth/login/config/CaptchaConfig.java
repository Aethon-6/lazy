package com.lazy.auth.login.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : yangwx
 * @description :
 * @createDate : 2024/12/6
 */
@Data
@Component
@ConfigurationProperties(prefix = "system.public.basics.captcha")
public class CaptchaConfig {
    /**
     * 是否开启验证码
     */
    private boolean enabled;
    /**
     * 验证码长度
     */
    private int length;
}
