package fr.negosud.api.controllers;

import fr.negosud.api.model.OrderStatus;
import fr.negosud.api.model.SupplierOrder;
import fr.negosud.api.service.SupplierOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SupplierOrderController {

    @Autowired
    private SupplierOrderService supplierOrderService;

    @GetMapping("/supplier-orders")
    public Iterable<SupplierOrder> getSupplierOrders() {
        return supplierOrderService.getSupplierOrders();
    }

    @GetMapping("/supplier-orders/{id}")
    public SupplierOrder getSupplierOrder(@PathVariable("id") final Integer id) {
        Optional<SupplierOrder> order = supplierOrderService.getSupplierOrder(id);
        if(order.isPresent()){
            return order.get();
        } else {
            return null;
        }
    }

    @PostMapping("/supplier-orders")
    public SupplierOrder createSupplierOrder(@RequestBody SupplierOrder supplierOrder) {
        return supplierOrderService.saveSupplierOrder(supplierOrder);
    }

    @PutMapping("/supplier-orders/{id}")
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

    @DeleteMapping("/supplier-orders/{id}")
    public void deleteSupplierOrder(@PathVariable("id") final Integer id) {
        supplierOrderService.deleteSupplierOrder(id);
    }
}
