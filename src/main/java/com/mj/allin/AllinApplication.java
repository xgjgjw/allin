package com.mj.allin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mj.allin.modules.user.mapper")
public class AllinApplication {
    public static void main(String[] args) {
        SpringApplication.run(AllinApplication.class, args);
    }

}
