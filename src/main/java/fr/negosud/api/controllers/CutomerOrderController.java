package fr.negosud.api.controllers;

import fr.negosud.api.model.CustomerOrder;
import fr.negosud.api.model.OrderStatus;
import fr.negosud.api.model.SupplierOrder;
import fr.negosud.api.service.CustomerOrderService;
import fr.negosud.api.service.SupplierOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CutomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/customer-orders")
    public Iterable<CustomerOrder> getCustomerOrders() {
        return customerOrderService.getCustomerOrders();
    }

    @GetMapping("/customer-orders/{id}")
    public CustomerOrder getSupplierOrder(@PathVariable("id") final Integer id) {
        Optional<CustomerOrder> customerOrder = customerOrderService.getCustomerOrder(id);
        if(customerOrder.isPresent()){
            return customerOrder.get();
        } else {
            return null;
        }
    }

    @PostMapping("/customer-orders")
    public CustomerOrder createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.saveCustomerOrder(customerOrder);
    }

    @PutMapping("/customer-orders/{id}")
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
            int invoiceSupplier = customerOrder.getInvoiceCustomer();
            if(invoiceSupplier != 0){
                currentCustomerOrder.setInvoiceCustomer(invoiceSupplier);
            }

            OrderStatus orderStatus = customerOrder.getOrderStatus();
            if(orderStatus  != null){
                currentCustomerOrder .setOrderStatus(orderStatus);
            }
            customerOrderService.saveCustomerOrder(currentCustomerOrder);
            return currentCustomerOrder;
        } else {
            return null;
        }
    }

    @DeleteMapping("/customer-orders/{id}")
    public void deleteCustomerOrder(@PathVariable("id") final Integer id) {
        customerOrderService.deleteCustomerOrder(id);
    }
}
