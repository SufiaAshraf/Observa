package com.observa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class ObservaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ObservaApplication.class, args);
    }
}
