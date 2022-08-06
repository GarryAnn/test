package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("http://localhost:9090");
    }

}

// 1、ssm 配置文件 简化 ------> application.properties
// 2、依赖整合，ssm jar，依赖多且版本容易冲突
// 3、注解简化，比如restController，返回json / controller @responseBody
// 4、打包，简化部署jar，继承tomcat
// 5、自动配置，
// ---> 约束>配置>编码
