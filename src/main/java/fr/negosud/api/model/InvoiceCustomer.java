package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "invoice_customer")
public class InvoiceCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idInvoiceCustomer;

    //Enum
    private String status;

    @Column(name = "id_order")
    private int idOrder;

}
