package fr.negosud.api.service;

import fr.negosud.api.model.ProductOrder;
import fr.negosud.api.repository.ProductOrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    public Iterable<ProductOrder> getProductOrders() {
        return productOrderRepository.findAll();
    }

    public Optional<ProductOrder> getProductOrder(final Integer id) {
        return productOrderRepository.findById(id);
    }

    public void deleteProductOrder(final Integer id) {
        productOrderRepository.deleteById(id);
    }

    public ProductOrder saveProductOrder(ProductOrder productOrder) {
        ProductOrder savedProductOrder = productOrderRepository.save(productOrder);
        return savedProductOrder;
    }
}
