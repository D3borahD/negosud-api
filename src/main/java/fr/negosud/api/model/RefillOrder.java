package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "refill_order")
public class RefillOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idRefillOrder;

    private float price;

    @Enumerated
    private OrderStatus orderStatus;

    @Column(name = "id_product")
    private int idProduct;

}
