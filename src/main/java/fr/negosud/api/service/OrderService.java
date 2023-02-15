package fr.negosud.api.service;

import fr.negosud.api.model.Address;
import fr.negosud.api.model.Order;
import fr.negosud.api.repository.AddressRepository;
import fr.negosud.api.repository.OrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(final Integer id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(final Integer id) {
        orderRepository.deleteById(id);
    }

    public Order saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

}
