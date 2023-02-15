package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private int id;

    @Column(name = "name", nullable=false, unique=true)
    private String name;

    @Column(name = "unite_price")
    private float unitePrice;

    @Column(name = "package_price")
    private float packagePrice;

    private String year;

    private int quantity;

    @Column(name = "need_refill")
     private boolean needRefill;

    private String comment;

    private String cepage;

    @Column(name = "automatic_replenishment_threshold")
    private int automaticReplenishmentTreshold;

}
