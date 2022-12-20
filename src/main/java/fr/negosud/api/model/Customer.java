package fr.negosud.api.model;

import jakarta.persistence.*;

// generate getteurs & setteurs
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCustomer;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "mail")
    private  String mailCustomer;

}
