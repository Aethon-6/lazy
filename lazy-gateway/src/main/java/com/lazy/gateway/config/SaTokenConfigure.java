package com.lazy.gateway.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

@Configuration
public class SaTokenConfigure {
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        String[] excludes = new String[]{"/auth/login", "/auth/query/code"};

        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")/* 拦截全部path */
                // 开放地址
                .addExclude(excludes)
                .setAuth(o -> {
                    // 登录校验 -- 拦截所有路由，并排除/auth/login用于开放登录
                    for (String exclude : excludes) {
                        SaRouter.match("/**", exclude, r -> StpUtil.checkLogin());
                    }
                    /*SaRouter.match("/**")
                            .check(() -> {
                                StpUtil.isLogin();
                            });*/
                })
                .setError(e -> {
                    // 设置错误返回格式为JSON
                    ServerWebExchange exchange = SaReactorSyncHolder.getContext();
                    exchange.getResponse().getHeaders().set("Content-Type", "application/json; charset=utf-8");
                    return SaResult.error(e.getMessage());
                })
                .setBeforeAuth(obj -> {
                    // ---------- 设置跨域响应头 ----------
                    SaHolder.getResponse()
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*");
                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS)
                            .free(r -> System.out.println("--------OPTIONS预检请求，不做处理"))
                            .back();
                });
    }
}
