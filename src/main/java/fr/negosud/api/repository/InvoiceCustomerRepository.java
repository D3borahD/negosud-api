package fr.negosud.api.repository;

import fr.negosud.api.model.InvoiceCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceCustomerRepository extends CrudRepository<InvoiceCustomer, Integer> {
}
