package fr.negosud.api.repository;

import fr.negosud.api.model.RefillOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefillOrderRepository extends CrudRepository<RefillOrder, Integer> {
}
