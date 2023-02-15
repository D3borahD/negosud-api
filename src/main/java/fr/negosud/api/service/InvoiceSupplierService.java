package fr.negosud.api.service;

import fr.negosud.api.model.InvoiceCustomer;
import fr.negosud.api.model.InvoiceSupplier;
import fr.negosud.api.repository.InvoiceCustomerRepository;
import fr.negosud.api.repository.InvoiceSupplierRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class InvoiceSupplierService {

    @Autowired
    private InvoiceSupplierRepository invoiceSupplierRepository;

    public Iterable<InvoiceSupplier> getInvoiceSuppliers() {
        return invoiceSupplierRepository.findAll();
    }

    public Optional<InvoiceSupplier> getInvoiceSupplier(final Integer id) {
        return invoiceSupplierRepository.findById(id);
    }

    public void deleteInvoiceSupplier(final Integer id) {
        invoiceSupplierRepository.deleteById(id);
    }

    public InvoiceSupplier saveInvoiceSupplier(InvoiceSupplier invoiceSupplier) {
        InvoiceSupplier savedInvoiceSupplier = invoiceSupplierRepository.save(invoiceSupplier);
        return savedInvoiceSupplier;
    }

}
