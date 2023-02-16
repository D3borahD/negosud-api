package fr.negosud.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "house_id")
    private int houseId;
    @Column(name = "familly_id")
    private int famillyId;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Set<RefillOrder> refillOrders = new HashSet<>();

}
