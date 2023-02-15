package fr.negosud.api.service;

import fr.negosud.api.model.Supplier;
import fr.negosud.api.repository.SupplierRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Iterable<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplier(Integer id) {
        return supplierRepository.findById(id);
    }

    public void deleteSupplier(final Integer id) {
        supplierRepository.deleteById(id);
    }

    public Supplier saveSupplier(Supplier supplier) {
        Supplier savedSupplier = supplierRepository.save(supplier);
        return savedSupplier;
    }

}
