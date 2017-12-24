package com.hdw.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;

/**
 * Spring Boot 应用启动类
 *
 */
// Spring Boot 应用的标识
@SpringBootApplication
@MapperScan("com.hdw.springboot.mapper")
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        Logger logger =  Logger.getLogger("test");
        logger.info("++++++++++++++++++++++++++++testing");
        SpringApplication.run(Application.class,args);
    }
}
