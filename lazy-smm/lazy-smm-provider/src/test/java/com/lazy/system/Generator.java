package com.lazy.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class Generator {
    @Test
    public void generator() {
        List<String> tableNames = Arrays.asList("lazy_user");
        // 数据库连接地址，
        String url = "jdbc:mysql://1.94.66.77:3306/lazy?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
        // 数据库用户名
        String name = "root";
        // 数据库密码
        String password = "Buzhidao@1";
        FastAutoGenerator.create(url, name, password)
                .globalConfig(builder -> {
                    builder.author("ywx")               //作者
                            .outputDir(System.getProperty("user.dir") + "/src/main/java")    //输出路径(写到java目录)
                            //.enableSwagger()           //开启swagger
                            .commentDate("yyyy-MM-dd")
                    //.fileOverride()//开启覆盖之前生成的文件
                    ;

                })
                .packageConfig(builder -> {
                    builder.parent("com.lazy.system")
                            .moduleName("user")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableNames)
                            .addTablePrefix("lazy_")
                            .serviceBuilder()
                            .formatServiceFileName("I%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("del_flag")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            .enableBaseResultMap()  //生成通用的resultMap
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .mapperAnnotation(Mapper.class)
                            .formatXmlFileName("%sMapper");
                })
                .templateEngine(new FreemarkerTemplateEngine())// 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
