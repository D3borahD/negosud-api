package fr.negosud.api.repository;

import fr.negosud.api.model.Customer;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
