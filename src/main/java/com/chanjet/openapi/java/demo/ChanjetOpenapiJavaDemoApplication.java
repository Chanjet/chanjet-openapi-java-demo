package com.chanjet.openapi.java.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication
public class ChanjetOpenapiJavaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChanjetOpenapiJavaDemoApplication.class, args);
    }

}
