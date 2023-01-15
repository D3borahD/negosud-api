package fr.negosud.api.controllers;

import fr.negosud.api.model.Product;
import fr.negosud.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/produits")
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/produits/{id}")
    public Product getProduct(@PathVariable("id") final Integer id) {
        Optional<Product> product = productService.getProduct(id);
        if(product.isPresent()){
            return product.get();
        } else {
            return null;
        }
    }

    @PostMapping("/produits")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("produits/{id}")
    public Product updateProduct(@PathVariable("id") final Integer id, @RequestBody Product product){
        Optional<Product> p = productService.getProduct(id);
        if(p.isPresent()){
            Product currentProduct = p.get();

            String nameProduct = product.getNameProduct();
            if(nameProduct != null){
                currentProduct.setNameProduct(nameProduct);
            }
            float unitePrice = product.getUnitePrice();
            if(unitePrice != 0.0f) {
                currentProduct.setUnitePrice(unitePrice);
            }
            float packagePrice = product.getPackagePrice();
            if(packagePrice != 0.0f) {
                currentProduct.setPackagePrice(packagePrice);
            }
            String year = product.getYear();
            if(year != null){
                currentProduct.setYear(year);
            }
            int quantity = product.getQuantity();
            if(quantity != 0){
                currentProduct.setQuantity(quantity);
            }

            int needRefill = product.getNeedRefill();
            if(needRefill != 0){
                currentProduct.setNeedRefill(needRefill);
            }
            String comment = product.getComment();
            if(comment != null){
                currentProduct.setComment(comment);
            }
            String cepage = product.getCepage();
            if(cepage != null){
                currentProduct.setCepage(cepage);
            }
            int automaticReplenishmentTreshold = product.getAutomaticReplenishmentTreshold();
            if (automaticReplenishmentTreshold != 0){
                currentProduct.setAutomaticReplenishmentTreshold(automaticReplenishmentTreshold);
            }
            productService.saveProduct(currentProduct);
            return currentProduct;
        } else {
            return null;
        }
    }

    @DeleteMapping("produits/{id}")
    public void deleteProduct(@PathVariable("id") final Integer id) {
        productService.deleteProduct(id);
    }


}
