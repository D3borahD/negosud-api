package fr.negosud.api.controllers;

import fr.negosud.api.model.ShoppingCart;
import fr.negosud.api.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/paniers")
    public Iterable<ShoppingCart> getShoppingCarts() {
        return shoppingCartService.getShoppingCarts();
    }

    @GetMapping("/paniers/{id}")
    public ShoppingCart getShoppingCart(@PathVariable("id") final Integer id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCart(id);
        if(shoppingCart.isPresent()){
            return shoppingCart.get();
        } else {
            return null;
        }
    }

    @PostMapping("/paniers")
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.saveShoppingCart(shoppingCart);
    }

    @DeleteMapping("/paniers/{id}")
    public void deleteShoppingCart(@PathVariable("id") final Integer id) {
        shoppingCartService.deleteShoppingCart(id);
    }
}
