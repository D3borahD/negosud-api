package fr.negosud.api.controllers;

import fr.negosud.api.model.Order;
import fr.negosud.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/commandes")
    public Iterable<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/commandes/{id}")
    public Order getOrder(@PathVariable("id") final Integer id) {
        Optional<Order> order = orderService.getOrder(id);
        if(order.isPresent()){
            return order.get();
        } else {
            return null;
        }
    }


    @PostMapping("/commandes")
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/commandes/{id}")
    public Order updateOrder(@PathVariable("id") final Integer id, @RequestBody Order order){
        Optional<Order> o = orderService.getOrder(id);
        if(o.isPresent()){
            Order currentOrder = o.get();

            int quantityOrder = order.getQuantity();
            if(quantityOrder  != 0){
                currentOrder .setQuantity(quantityOrder);
            }
            LocalDate deliveryDate = order.getDeliveryDate();
            if(deliveryDate  != null){
                currentOrder .setDeliveryDate(deliveryDate);
            }
            int invoice = order.getInvoice();
            if(invoice  != 0){
                currentOrder .setInvoice(invoice);
            }
            String status = order.getStatus();
            if(status  != null){
                currentOrder .setStatus(status);
            }
            orderService.saveOrder(currentOrder);
            return currentOrder;
        } else {
            return null;
        }
    }

    @DeleteMapping("/commandes/{id}")
    public void deleteOrder(@PathVariable("id") final Integer id) {
        orderService.deleteOrder(id);
    }
}
