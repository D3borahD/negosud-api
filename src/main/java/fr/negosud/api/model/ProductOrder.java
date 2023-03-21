package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;
}
