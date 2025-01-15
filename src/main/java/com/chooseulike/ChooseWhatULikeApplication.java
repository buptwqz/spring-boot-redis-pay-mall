package com.chooseulike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.chooseulike.mapper")
@SpringBootApplication
public class ChooseWhatULikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChooseWhatULikeApplication.class, args);
    }
}
