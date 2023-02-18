package fr.negosud.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
