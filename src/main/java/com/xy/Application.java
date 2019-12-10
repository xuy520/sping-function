package com.xy;

import com.xy.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Function<User, String> uppercase() {
        System.out.printf("qqqq");
        return value -> value.getUserId().toUpperCase();
    }

}
