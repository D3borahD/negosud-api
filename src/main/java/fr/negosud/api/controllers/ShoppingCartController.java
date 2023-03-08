package fr.negosud.api.controllers;

import fr.negosud.api.model.House;
import fr.negosud.api.model.Product;
import fr.negosud.api.model.ShoppingCart;
import fr.negosud.api.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/shopping-carts")
    public Iterable<ShoppingCart> getShoppingCarts() {
        return shoppingCartService.getShoppingCarts();
    }

    @GetMapping("/shopping-carts/{id}")
    public ShoppingCart getShoppingCart(@PathVariable("id") final Integer id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCart(id);
        if(shoppingCart.isPresent()){
            return shoppingCart.get();
        } else {
            return null;
        }
    }

    @PutMapping("shopping-carts/{id}")
    public ShoppingCart updateShoppingCart(@PathVariable("id") final Integer id, @RequestBody ShoppingCart shoppingCart){
        Optional<ShoppingCart> s = shoppingCartService.getShoppingCart(id);
        if(s.isPresent()){
            ShoppingCart currentShoppingCart = s.get();

            Set<Product> product = shoppingCart.getProducts();
            if(product != null){
                currentShoppingCart.setProducts(product);
            }

            shoppingCartService.saveShoppingCart(currentShoppingCart);
            return currentShoppingCart;
        } else {
            return null;
        }
    }

    @PostMapping("/shopping-carts")
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.saveShoppingCart(shoppingCart);
    }

    @DeleteMapping("/shopping-carts/{id}")
    public void deleteShoppingCart(@PathVariable("id") final Integer id) {
        shoppingCartService.deleteShoppingCart(id);
    }
}
