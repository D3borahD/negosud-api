
package fr.negosud.api.controllers;


import fr.negosud.api.model.Customer;
import fr.negosud.api.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("static/index.html");
        return "test";
    }

  /*  @GetMapping("/client")
    public Iterable<Customer> getCustomer() {
        CustomerService customerService = new CustomerService();
        return customerService.getCustomers();
    }*/

}

