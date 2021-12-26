package com.dmy.codedesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dmy"})
public class CodeDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeDesignApplication.class, args);
    }

}
