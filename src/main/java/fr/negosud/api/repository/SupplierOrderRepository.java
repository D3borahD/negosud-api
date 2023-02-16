package fr.negosud.api.repository;

import fr.negosud.api.model.SupplierOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierOrderRepository extends CrudRepository<SupplierOrder, Integer> {
}
