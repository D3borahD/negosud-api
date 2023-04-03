package fr.negosud.api.service;

import fr.negosud.api.model.SupplierOrder;
import fr.negosud.api.repository.SupplierOrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class SupplierOrderService {
    @Autowired
    private SupplierOrderRepository supplierOrderRepository;

    public Iterable<SupplierOrder> getSupplierOrders() {
        return supplierOrderRepository.findAll();
    }

    public Optional<SupplierOrder> getSupplierOrder(final Integer id) {
        return supplierOrderRepository.findById(id);
    }

    public void deleteSupplierOrder(final Integer id) {
        supplierOrderRepository.deleteById(id);
    }

    public SupplierOrder saveSupplierOrder(SupplierOrder supplierOrder) {
        SupplierOrder savedSupplierOrder = supplierOrderRepository.save(supplierOrder);
        return savedSupplierOrder;
    }
}
