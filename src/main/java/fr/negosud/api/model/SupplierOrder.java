package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "supplier_order")
public class SupplierOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int orderNumber;

    private int quantity;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "invoice_supplier")
    private int invoiceSupplier;

    @Enumerated
    private OrderStatus orderStatus;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_order_id")
    private Set<InvoiceSupplier> invoiceSuppliers = new HashSet<>();
}
