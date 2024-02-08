package com.lazy.system;

import com.lazy.common.feign.annotation.EnableLazyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableLazyFeignClients
@EnableDiscoveryClient
public class LazySystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LazySystemApplication.class, args);
    }
}
