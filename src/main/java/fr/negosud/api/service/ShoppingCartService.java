package fr.negosud.api.service;

import fr.negosud.api.model.RefillOrder;
import fr.negosud.api.model.ShoppingCart;
import fr.negosud.api.repository.RefillOrderRepository;
import fr.negosud.api.repository.ShoppingCartRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public Iterable<ShoppingCart> getShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    public Optional<ShoppingCart> getShoppingCart(final Integer id) {
        return shoppingCartRepository.findById(id);
    }

    public void deleteShoppingCart(final Integer id) {
        shoppingCartRepository.deleteById(id);
    }

    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);
        return savedShoppingCart;
    }
}
