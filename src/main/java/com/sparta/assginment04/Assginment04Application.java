package com.sparta.assginment04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Assginment04Application {

    public static void main(String[] args) {
        SpringApplication.run(Assginment04Application.class, args);
    }

}
