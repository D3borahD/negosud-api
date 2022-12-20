package fr.negosud.api.service;

import fr.negosud.api.repository.CustomerRepository;
import fr.negosud.api.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}