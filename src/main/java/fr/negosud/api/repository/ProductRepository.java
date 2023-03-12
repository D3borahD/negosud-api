package fr.negosud.api.repository;

import fr.negosud.api.model.Familly;
import fr.negosud.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Iterable<Product> findByFamillyNameFamilly(String famillyName);
    public Iterable<Product> findByHouseNameHouse(String houseName);
    public Iterable<Product> getProductsByYear(String year);

    /*List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);*/
}
