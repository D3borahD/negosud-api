package fr.negosud.api.service;

import fr.negosud.api.model.Product;
import fr.negosud.api.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(final Integer id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(final Integer id) {
        productRepository.deleteById(id);
    }

    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
}
