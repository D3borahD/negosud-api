package fr.negosud.api.repository;

import fr.negosud.api.model.InvoiceSupplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceSupplierRepository extends CrudRepository<InvoiceSupplier, Integer> {
}
