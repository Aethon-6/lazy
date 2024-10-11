package com.lazy.common.mybatis;

import com.lazy.common.mybatis.config.MybatisPlusMetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MybatisAutoConfiguration implements WebMvcConfigurer {
    /**
     * mybatis-plus 自动填充配置
     *
     * @return MybatisPlusMetaObjectHandler
     */
    @Bean
    public MybatisPlusMetaObjectHandler mybatisPlusMetaObjectHandler() {
        return new MybatisPlusMetaObjectHandler();
    }
}
