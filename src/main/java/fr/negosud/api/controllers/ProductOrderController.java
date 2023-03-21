package fr.negosud.api.controllers;

import fr.negosud.api.model.Product;
import fr.negosud.api.model.ProductOrder;
import fr.negosud.api.service.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping("/product-orders")
    public Iterable<ProductOrder> getProductOrders() {
        return productOrderService.getProductOrders();
    }

    @GetMapping("/product-orders/{id}")
    public ProductOrder getSupplierOrder(@PathVariable("id") final Integer id) {
        Optional<ProductOrder> productOrder = productOrderService.getProductOrder(id);
        if(productOrder.isPresent()){
            return productOrder.get();
        } else {
            return null;
        }
    }

    @PostMapping("/product-orders")
    public ProductOrder createProductOrder(@RequestBody ProductOrder productOrder) {
        return productOrderService.saveProductOrder(productOrder);
    }

    @PutMapping("/product-orders/{id}")
    public ProductOrder updateProductOrder(@PathVariable("id") final Integer id, @RequestBody ProductOrder productOrder){
        Optional<ProductOrder> o = productOrderService.getProductOrder(id);
        if(o.isPresent()){
            ProductOrder currentProductOrder = o.get();
            
            Product product = productOrder.getProduct();
            if(product  != null){
                currentProductOrder.setProduct(product);
            }
            productOrderService.saveProductOrder(currentProductOrder);
            return currentProductOrder;
        } else {
            return null;
        }
    }

    @DeleteMapping("/product-orders/{id}")
    public void deleteCustomerOrder(@PathVariable("id") final Integer id) {
        productOrderService.deleteProductOrder(id);
    }


}
