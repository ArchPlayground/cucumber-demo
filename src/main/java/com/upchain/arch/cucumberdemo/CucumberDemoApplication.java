package com.upchain.arch.cucumberdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CucumberDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CucumberDemoApplication.class, args);
    }

}
