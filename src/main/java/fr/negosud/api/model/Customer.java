package fr.negosud.api.model;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCustomer;

    @Column(name = "first_name", nullable=false)
    private String firstName;

    @Column(name = "last_name", nullable=false)
    private  String lastName;

    @Column(name = "mail", nullable=false, unique=true)
    @Email
    private  String mailCustomer;

    @Column(nullable=false)
    @Size(min = 2, max = 100)
    private  String password;

    @Enumerated
    private Role role;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Set <CustomerOrder> Orders = new HashSet<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Set <ShoppingCart> ShoppingCarts = new HashSet<>();

   /* @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order")
    private Set <InvoiceCustomer> invoiceCustomers = new HashSet<>();*/

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Set<Address> addresses = new HashSet<>();



}
