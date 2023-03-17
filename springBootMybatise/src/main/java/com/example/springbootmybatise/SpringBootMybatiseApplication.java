package com.example.springbootmybatise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.example.springbootmybatise.dao.mapper")
@MapperScan("com.example.springbootmybatise.Mapper")
@ServletComponentScan
public class SpringBootMybatiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatiseApplication.class, args);
    }

}
