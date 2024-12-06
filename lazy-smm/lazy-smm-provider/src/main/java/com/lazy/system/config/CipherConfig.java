package com.lazy.system.config;

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
@ConfigurationProperties(prefix = "system.public.basics.cipher")
public class CipherConfig {
    /**
     * 默认密码
     */
    private String defaultPWD;
}
