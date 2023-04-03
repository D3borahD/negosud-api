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

   @Column(name = "is_paid")
   private boolean isPaid;

}
