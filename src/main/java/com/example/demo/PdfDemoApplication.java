package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.demo.Service")
@SpringBootApplication
public class PdfDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(PdfDemoApplication.class, args);
    }

}
