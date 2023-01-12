package com.xmg;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoDataSourceProxy
public class Provider2Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider2Application.class,args);
    }
}
