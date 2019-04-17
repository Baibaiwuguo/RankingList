package com.wlxh.just;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wlxh.just.dao")
public class JustApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustApplication.class, args);
    }

}
