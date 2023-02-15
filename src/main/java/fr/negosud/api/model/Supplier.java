package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

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

}
