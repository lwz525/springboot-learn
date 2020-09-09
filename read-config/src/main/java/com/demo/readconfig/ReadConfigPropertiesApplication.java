package com.demo.readconfig;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProfileProperties.class)
public class ReadConfigPropertiesApplication implements InitializingBean {
//    private final LibraryPropertiesDTO library;
//
//    public ReadConfigPropertieseApplication(LibraryPropertiesDTO library) {
//        this.library = library;
//    }
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println(library.getLocation());
//        System.out.println(library.getBooks());
//    }

    private final ProfileProperties properties;

    public ReadConfigPropertiesApplication(ProfileProperties properties) {
        this.properties = properties;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(properties.toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(ReadConfigPropertiesApplication.class, args);
    }


}
