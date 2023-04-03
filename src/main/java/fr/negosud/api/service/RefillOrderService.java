package fr.negosud.api.service;

import fr.negosud.api.model.InvoiceSupplier;
import fr.negosud.api.model.RefillOrder;
import fr.negosud.api.repository.InvoiceSupplierRepository;
import fr.negosud.api.repository.RefillOrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class RefillOrderService {
    @Autowired
    private RefillOrderRepository refillOrderRepository;

    public Iterable<RefillOrder> getRefillOrders() {
        return refillOrderRepository.findAll();
    }

    public Optional<RefillOrder> getRefillOrder(final Integer id) {
        return refillOrderRepository.findById(id);
    }

    public void deleteRefillOrder(final Integer id) {
        refillOrderRepository.deleteById(id);
    }

    public RefillOrder saveRefillOrder(RefillOrder refillOrder) {
        RefillOrder savedRefillOrder = refillOrderRepository.save(refillOrder);
        return savedRefillOrder;
    }
}
