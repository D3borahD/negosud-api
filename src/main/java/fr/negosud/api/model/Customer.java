package fr.negosud.api.model;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
    @Email
    private  String mailCustomer;

   /* @Column(nullable=false)
    @Size(min = 2, max = 100)
    private  String password;*/

  /*  @Enumerated
    private Role role;*/

}
