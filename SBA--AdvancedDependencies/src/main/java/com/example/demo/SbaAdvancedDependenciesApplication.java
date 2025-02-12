package com.example.demo;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SbaAdvancedDependenciesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbaAdvancedDependenciesApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // Save some customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // Fetch all customers
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (Customer customer : repository.findAll()) {
                System.out.println(customer);
            }
            System.out.println();

            // Fetch individual customer by ID
            Optional<Customer> customerOptional = repository.findById(1L);
            System.out.println("Customer found with findById(1L):");
            System.out.println("--------------------------------");
            if (customerOptional.isPresent()) {
                System.out.println(customerOptional.get());
            } else {
                System.out.println("Customer not found");
            }
            System.out.println();

            // Fetch customers by last name
            System.out.println("Customers found with findByLastName('Bauer')");
            System.out.println("--------------------------------------------");

            List<Customer> bauers = repository.findByLastName("Bauer");

            if (bauers != null && !bauers.isEmpty()) {  
                for (Customer bauer : bauers) {
                    System.out.println(bauer);
                }
            } else {
                System.out.println("No customers found with last name 'Bauer'");
            }
        };
    }
}
