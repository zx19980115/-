package com.zx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描我们的mapper文件夹(放到了config包下)
@SpringBootApplication
public class MybaitsPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybaitsPlusApplication.class, args);
    }

}
