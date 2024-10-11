package com.lazy.auth;

import com.lazy.common.feign.annotation.EnableLazyFeignClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@EnableLazyFeignClients
@SpringBootApplication
public class LazyAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LazyAuthApplication.class, args);
        log.info("启动成功：{}", "😊😆😘🤩");
    }
}
