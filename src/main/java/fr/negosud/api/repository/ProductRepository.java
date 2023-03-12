package fr.negosud.api.repository;

import fr.negosud.api.model.Familly;
import fr.negosud.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Iterable<Product> findByFamillyNameFamilly(String famillyName);
    Iterable<Product> findByHouseNameHouse(String houseName);
    Iterable<Product> getProductsByYear(String year);

    Iterable<Product> findByOrderByUnitePriceAsc();
    Iterable<Product> findByOrderByUnitePriceDesc();

    /*List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);*/
}
