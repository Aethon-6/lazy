package com.lazy.auth;

import com.lazy.common.feign.annotation.EnableLazyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableLazyFeignClients
@SpringBootApplication
public class LazyAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LazyAuthApplication.class, args);
    }
}
