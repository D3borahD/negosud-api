package fr.negosud.api.controllers;

import fr.negosud.api.model.CustomerOrder;
import fr.negosud.api.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/commandes")
    public Iterable<CustomerOrder> getCustomerOrders() {
        return customerOrderService.getCustomerOrders();
    }

    @GetMapping("/commandes/{id}")
    public CustomerOrder getCustomerOrder(@PathVariable("id") final Integer id) {
        Optional<CustomerOrder> customerOrder = customerOrderService.getCustomerOrder(id);
        if(customerOrder.isPresent()){
            return customerOrder.get();
        } else {
            return null;
        }
    }


    @PostMapping("/commandes")
    public CustomerOrder createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.saveCustomerOrder(customerOrder);
    }

    @PutMapping("/commandes/{id}")
    public CustomerOrder updateCustomerOrder(@PathVariable("id") final Integer id, @RequestBody CustomerOrder customerOrder){
        Optional<CustomerOrder> o = customerOrderService.getCustomerOrder(id);
        if(o.isPresent()){
            CustomerOrder currentCustomerOrder = o.get();

            int quantityCustomerOrder = customerOrder.getQuantity();
            if(quantityCustomerOrder != 0){
                currentCustomerOrder.setQuantity(quantityCustomerOrder);
            }
            LocalDate deliveryDate = customerOrder.getDeliveryDate();
            if(deliveryDate  != null){
                currentCustomerOrder.setDeliveryDate(deliveryDate);
            }
           /* int invoice = customerOrder.getInvoice();
            if(invoice  != 0){
                currentCustomerOrder.setInvoice(invoice);
            }*/
           /* String status = order.getStatus();
            if(status  != null){
                currentOrder .setStatus(status);
            }*/
            customerOrderService.saveCustomerOrder(currentCustomerOrder);
            return currentCustomerOrder;
        } else {
            return null;
        }
    }

    @DeleteMapping("/commandes/{id}")
    public void deleteOrder(@PathVariable("id") final Integer id) {
        customerOrderService.deleteCustomerOrder(id);
    }
}
