package com.aula.desc.config;

import com.aula.desc.entities.Instrutor;
import com.aula.desc.repositores.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {

    @Autowired
    private InstrutorRepository userRepository;

    @Override
    public void run(String... args) throws Exception {


        Instrutor instrutor1 = new Instrutor(null, 123456, "João Silva", LocalDate.of(1980, 5, 20), 2);
        Instrutor instrutor2 = new Instrutor(null, 123478, "Ana Maria ", LocalDate.of(1985, 7, 25), 5);

        userRepository.saveAll(Arrays.asList(instrutor1, instrutor2));
    }

}

