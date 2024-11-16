package com.aula.desc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula {
    public static void main(String[] args) {
        SpringApplication.run(Aula.class, args);
    }
    @Bean
    public CommandLineRunner initialization(){
        return  args -> {
            System.out.println("Ok");
        };
    }
}