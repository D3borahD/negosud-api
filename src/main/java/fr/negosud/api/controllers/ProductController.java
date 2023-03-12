package fr.negosud.api.controllers;

import fr.negosud.api.model.Familly;
import fr.negosud.api.model.House;
import fr.negosud.api.model.Product;
import fr.negosud.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") final Integer id) {
        Optional<Product> product = productService.getProduct(id);
        if(product.isPresent()){
            return product.get();
        } else {
            return null;
        }
    }

    @GetMapping("/products/familly/{nameFamilly}")
    public Iterable<Product> getProductsByFamily (@PathVariable String nameFamilly) {
        return  productService.getProductsByFamilly(nameFamilly);
    }
    @GetMapping("/products/houses/{nameHouse}")
    public Iterable<Product> getProductsByHouse(@PathVariable String nameHouse) {
        return  productService.getProductsByHouse(nameHouse);
    }
    @GetMapping("/products/year/{year}")
    public Iterable<Product> getProductsByYear (@PathVariable String year) {
        return  productService.getProductsByYear(year);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("products/{id}")
    public Product updateProduct(@PathVariable("id") final Integer id, @RequestBody Product product){
        Optional<Product> p = productService.getProduct(id);
        if(p.isPresent()){
            Product currentProduct = p.get();
            String imageUrl = product.getImageUrl();
            if(imageUrl != null){
                currentProduct.setImageUrl(imageUrl);
            }
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
            boolean needRefill = product.isNeedRefill();
            if(needRefill != false){
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
            boolean automaticReplenishmentTreshold = product.isAutomaticReplenishmentTreshold();
            if (automaticReplenishmentTreshold != false){
                currentProduct.setAutomaticReplenishmentTreshold(automaticReplenishmentTreshold);
            }
            Familly familly = product.getFamilly();
            if(familly != null) {
                currentProduct.setFamilly(familly);
            }
            House house = product.getHouse();
            if(house != null) {
                currentProduct.setHouse(house);
            }
            productService.saveProduct(currentProduct);
            return currentProduct;
        } else {
            return null;
        }
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable("id") final Integer id) {
        productService.deleteProduct(id);
    }


}
