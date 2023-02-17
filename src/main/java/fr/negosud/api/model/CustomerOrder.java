package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int orderNumber;

    private int quantity;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "invoice_customer")
    private int invoiceCustomer;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_order_id")
    private Set<InvoiceCustomer> invoiceCustomers = new HashSet<>();


}
