package fr.negosud.api.service;

import fr.negosud.api.repository.CustomerRepository;
import fr.negosud.api.model.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(final Integer id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(final Integer id) {
        customerRepository.deleteById(id);
    }

    public Customer saveCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

}