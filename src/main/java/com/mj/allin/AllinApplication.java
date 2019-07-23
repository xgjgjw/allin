package com.mj.allin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


@MapperScan("com.mj.allin.modules.user.mapper")
@EnableScheduling
@SpringBootApplication
@PropertySource({"classpath:logback.properties"})
public class AllinApplication {
    public static void main(String[] args) {
        SpringApplication.run(AllinApplication.class, args);
    }

}
