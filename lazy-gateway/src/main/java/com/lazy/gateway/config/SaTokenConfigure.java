package com.lazy.gateway.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.lazy.common.core.domain.R;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfigure {
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")/* 拦截全部path */
                // 开放地址
                .addExclude("/favicon.ico", "/auth/query/code")
                .setAuth(o -> {
                    // 登录校验 -- 拦截所有路由，并排除/auth/login用于开放登录
                    SaRouter.match("/**", "/auth/login", r -> StpUtil.checkLogin());
                })
                .setError(e -> {
                    return SaResult.error(e.getMessage());
                });
    }
}
