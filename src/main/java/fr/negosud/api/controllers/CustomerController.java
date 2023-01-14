package fr.negosud.api.controllers;

import fr.negosud.api.service.CustomerService;
import fr.negosud.api.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/clients")
    public Iterable<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/clients/{id}")
    public Customer getCustomer(@PathVariable("id") final Integer id) {
        Optional<Customer> customer = customerService.getCustomer(id);
        if(customer.isPresent()){
            return customer.get();
        } else {
            return null;
        }
    }

    @PostMapping("/clients")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("clients/{id}")
    public Customer updateCustomer(@PathVariable("id") final Integer id, @RequestBody Customer customer){
        Optional<Customer> c = customerService.getCustomer(id);
        if(c.isPresent()){
            Customer currentCustomer = c.get();

            String firstName = customer.getFirstName();
            if(firstName != null){
                currentCustomer.setFirstName(firstName);
            }
            String lastName = customer.getLastName();
            if(lastName != null) {
                currentCustomer.setLastName(lastName);
            }
            String mail = customer.getMailCustomer();
            if(mail != null) {
                currentCustomer.setMailCustomer(mail);
            }
            customerService.saveCustomer(currentCustomer);
            return currentCustomer;
        } else {
            return null;
        }
    }

    @DeleteMapping("customers/{id}")
    public void deleteCustomer(@PathVariable("id") final Integer id) {
        customerService.deleteCustomer(id);
    }


}
