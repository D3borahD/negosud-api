package fr.negosud.api.controllers;

import fr.negosud.api.service.CustomerService;
import fr.negosud.api.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/client")
    public Iterable<Customer> getCustomers() {
        return customerService.getCustomers();
    }

}
