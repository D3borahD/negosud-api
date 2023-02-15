package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private int orderNumber;

    private int quantity;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    private int invoice;

    // ENUM
    private String status;
}
