package fr.negosud.api.controllers;

import fr.negosud.api.model.OrderStatus;
import fr.negosud.api.model.SupplierOrder;
import fr.negosud.api.service.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class SupplierOrderController {

    @Autowired
    private SupplierOrderService supplierOrderService;

    @GetMapping("/commandes_fournisseurs")
    public Iterable<SupplierOrder> getSupplierOrders() {
        return supplierOrderService.getSupplierOrders();
    }

    @GetMapping("/commandes_fournisseurs/{id}")
    public SupplierOrder getSupplierOrder(@PathVariable("id") final Integer id) {
        Optional<SupplierOrder> order = supplierOrderService.getSupplierOrder(id);
        if(order.isPresent()){
            return order.get();
        } else {
            return null;
        }
    }

    @PostMapping("/commandes_fournisseurs")
    public SupplierOrder createSupplierOrder(@RequestBody SupplierOrder supplierOrder) {
        return supplierOrderService.saveSupplierOrder(supplierOrder);
    }

    @PutMapping("/commandes_fournisseurs/{id}")
    public SupplierOrder updateSupplierOrder(@PathVariable("id") final Integer id, @RequestBody SupplierOrder supplierOrder){
        Optional<SupplierOrder> o = supplierOrderService.getSupplierOrder(id);
        if(o.isPresent()){
            SupplierOrder currentSupplierOrder = o.get();

            int quantitySupplierOrder = supplierOrder.getQuantity();
            if(quantitySupplierOrder != 0){
                currentSupplierOrder.setQuantity(quantitySupplierOrder);
            }
            LocalDate deliveryDate = supplierOrder.getDeliveryDate();
            if(deliveryDate  != null){
                currentSupplierOrder.setDeliveryDate(deliveryDate);
            }
            int invoiceSupplier = supplierOrder.getInvoiceSupplier();
            if(invoiceSupplier != 0){
                currentSupplierOrder.setInvoiceSupplier(invoiceSupplier);
            }
            
            OrderStatus orderStatus = supplierOrder.getOrderStatus();
            if(orderStatus  != null){
                currentSupplierOrder .setOrderStatus(orderStatus);
            }
            supplierOrderService.saveSupplierOrder(currentSupplierOrder);
            return currentSupplierOrder;
        } else {
            return null;
        }
    }

    @DeleteMapping("/commandes_fournisseurs/{id}")
    public void deleteSupplierOrder(@PathVariable("id") final Integer id) {
        supplierOrderService.deleteSupplierOrder(id);
    }
}
