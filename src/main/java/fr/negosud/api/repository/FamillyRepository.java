package fr.negosud.api.repository;

import fr.negosud.api.model.Familly;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamillyRepository extends CrudRepository<Familly, Integer> {

}
