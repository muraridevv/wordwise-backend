package com.example.devbackend;

import com.example.devbackend.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DevBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevBackendApplication.class, args);
    }

}
