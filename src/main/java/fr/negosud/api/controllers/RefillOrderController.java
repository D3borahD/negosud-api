package fr.negosud.api.controllers;

import fr.negosud.api.model.OrderStatus;
import fr.negosud.api.model.RefillOrder;
import fr.negosud.api.service.RefillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RefillOrderController {

    @Autowired
    private RefillOrderService refillOrderService;

    @GetMapping("/recharge_commandes")
    public Iterable<RefillOrder> getRefillOrders() {
        return refillOrderService.getRefillOrders();
    }

    @GetMapping("/recharge_commandes/{id}")
    public RefillOrder getRefillOrder(@PathVariable("id") final Integer id) {
        Optional<RefillOrder> refillOrder = refillOrderService.getRefillOrder(id);
        if(refillOrder.isPresent()){
            return refillOrder.get();
        } else {
            return null;
        }
    }

    @PostMapping("/recharge_commandes")
    public RefillOrder createRefillOrder(@RequestBody RefillOrder refillOrder) {
        return refillOrderService.saveRefillOrder(refillOrder);
    }

    @PutMapping("/recharge_commandes/{id}")
    public RefillOrder updateRefillOrder(@PathVariable("id") final Integer id, @RequestBody RefillOrder refillOrder){
        Optional<RefillOrder> r = refillOrderService.getRefillOrder(id);
        if(r.isPresent()){
            RefillOrder currentRefillOrder= r.get();

            float price = refillOrder.getPrice();
            if(price  != 0){
                currentRefillOrder.setPrice(price);
            }
            OrderStatus orderStatus = refillOrder.getOrderStatus();
            if(orderStatus  != null){
                currentRefillOrder.setOrderStatus(orderStatus);
            }
            int idProduct = refillOrder.getIdProduct();
            if(idProduct  != 0){
                currentRefillOrder.setIdProduct(idProduct);
            }
            refillOrderService.saveRefillOrder(currentRefillOrder);
            return currentRefillOrder;
        } else {
            return null;
        }
    }

    @DeleteMapping("/recharge_commandes/{id}")
    public void deleteRefillOrder(@PathVariable("id") final Integer id) {
        refillOrderService.deleteRefillOrder(id);
    }
}
