package fr.negosud.api.controllers;

import fr.negosud.api.model.ShoppingCart;
import fr.negosud.api.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/shopping-carts")
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.saveShoppingCart(shoppingCart);
    }

    @DeleteMapping("/shopping-carts/{id}")
    public void deleteShoppingCart(@PathVariable("id") final Integer id) {
        shoppingCartService.deleteShoppingCart(id);
    }
}
