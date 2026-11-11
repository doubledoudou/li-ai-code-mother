package com.tianji.liaicodemother;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tianji.liaicodemother.mapper")
public class LiAiCodeMotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiAiCodeMotherApplication.class, args);
    }

}
