package fr.negosud.api.repository;

import fr.negosud.api.model.House;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository <House, Integer> {
}
