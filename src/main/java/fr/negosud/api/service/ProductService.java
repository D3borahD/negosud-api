package fr.negosud.api.service;

import fr.negosud.api.model.Product;
import fr.negosud.api.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /*public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }*/
    public Iterable<Product> getProducts() {
        return productRepository.findByOrderByFamillyNameFamillyAscHouseNameHouseAscYearAsc();
    }

    public Iterable<Product> getProductsByYear(String year) {
        return productRepository.getProductsByYear(year);
    }

    public Iterable<Product> getProductsByFamilly(String famillyName) {
        return productRepository.findByFamillyNameFamilly(famillyName);
    }
    public Iterable<Product> getProductsByHouse(String houseName) {
        return productRepository.findByHouseNameHouse(houseName);
    }
    public Iterable<Product> getProductsByPriceAsc() {
        return productRepository.findByOrderByUnitePriceAsc();
    }
    public Iterable<Product> getProductsByPriceDesc() {
        return productRepository.findByOrderByUnitePriceDesc();
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
