package fr.negosud.api.service;

import fr.negosud.api.model.Address;
import fr.negosud.api.model.InvoiceCustomer;
import fr.negosud.api.repository.InvoiceCustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class InvoiceCustomerService {

    @Autowired
    private InvoiceCustomerRepository invoiceCustomerRepository;

    public Iterable<InvoiceCustomer> getInvoiceCustomers() {
        return invoiceCustomerRepository.findAll();
    }

    public Optional<InvoiceCustomer> getInvoiceCustome(final Integer id) {
        return invoiceCustomerRepository.findById(id);
    }

    public void deleteInvoiceCustomer(final Integer id) {
        invoiceCustomerRepository.deleteById(id);
    }

    public InvoiceCustomer saveInvoiceCustomer(InvoiceCustomer invoiceCustomer) {
        InvoiceCustomer savedInvoiceCustomer = invoiceCustomerRepository.save(invoiceCustomer);
        return savedInvoiceCustomer;
    }

}
