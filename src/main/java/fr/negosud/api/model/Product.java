package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idProduct;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "name", nullable=false, unique=true)
    private String nameProduct;

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
    private boolean automaticReplenishmentTreshold;

    @ManyToOne
    private Familly familly;

    @ManyToOne
    private House house;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Set<RefillOrder> refillOrders = new HashSet<>();

    @ManyToOne
    private Supplier supplier;


}
