package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "invoice_supplier")
public class InvoiceSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idInvoiceSupplier;

    @Column(name = "is_paid")
    private boolean isPaid;




}
