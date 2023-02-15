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
    @Column(name = "idCustomer")
    private int id;

    @Column(name = "first_name", nullable=false)
    private String firstName;

    @Column(name = "last_name", nullable=false)
    private  String lastName;

    @Column(name = "mail", nullable=false, unique=true)
    private  String mailCustomer;

}
