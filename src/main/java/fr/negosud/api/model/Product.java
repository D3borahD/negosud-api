package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idProduct;

    @Column(name = "name")
    private String nameProduct;

    @Column(name = "unite_price")
    private float unitePrice;

    @Column(name = "package_price")
    private float packagePrice;

    private String year;

    private int quantity;

     @Column(name = "need_refill")
    private int needRefill;

    private String comment;

    private String cepage;

    @Column(name = "automatic_replenishment_threshold")
    private int automaticReplenishmentTreshold;

}
