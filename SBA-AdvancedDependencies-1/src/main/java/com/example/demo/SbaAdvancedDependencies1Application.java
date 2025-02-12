package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.NoSuchElementException;

@SpringBootApplication
public class SbaAdvancedDependencies1Application {

    public static void main(String[] args) {
        SpringApplication.run(SbaAdvancedDependencies1Application.class, args);
    }

    @Bean
    CommandLineRunner runner(PersonRepository repository) {
        return args -> {
            Person person = new Person();
            person.setName("Prakhar");

            repository.save(person);
            Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
            
           
            System.out.println("Saved Person: ID=" + saved.getId() + ", Name=" + saved.getName());
        };
    }
}
