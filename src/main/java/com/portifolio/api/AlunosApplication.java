package com.portifolio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AlunosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlunosApplication.class, args);
    }

}
