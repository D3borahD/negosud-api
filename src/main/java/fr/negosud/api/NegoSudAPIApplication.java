package fr.negosud.api;


import fr.negosud.api.model.Customer;
import fr.negosud.api.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class NegoSudAPIApplication {

   /* @Autowired
    private CustomerService customerService;*/

    public static void main(String[] args) {

        SpringApplication.run(NegoSudAPIApplication.class, args);
    }

/*   @Override
    public void run(String... args) throws Exception {
        Iterable<Customer> customers = customerService.getCustomers();
       customers.forEach(customer -> System.out.println(customer.getName()));
    }*/


}
