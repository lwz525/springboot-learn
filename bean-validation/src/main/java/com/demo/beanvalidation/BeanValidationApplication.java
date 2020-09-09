package com.demo.beanvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class BeanValidationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeanValidationApplication.class, args);
    }
}
