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

    //Enum
    private String status;

    @Column(name = "id_order")
    private int idOrder;


}
