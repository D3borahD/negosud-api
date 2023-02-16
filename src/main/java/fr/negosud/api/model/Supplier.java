package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idSupplier;

    @Column(name = "name", nullable=false)
    private String nameSupplier;

    @Column(name = "mail",  nullable=false, unique=true)
    private  String mailSupplier;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private Set<Product> products = new HashSet<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private Set <SupplierOrder> SupplierOrders = new HashSet<>();

}
