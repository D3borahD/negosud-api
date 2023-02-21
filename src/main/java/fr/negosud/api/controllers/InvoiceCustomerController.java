package fr.negosud.api.controllers;

import fr.negosud.api.model.InvoiceCustomer;
import fr.negosud.api.service.InvoiceCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InvoiceCustomerController {

    @Autowired
    private InvoiceCustomerService invoiceCustomerService;

    @GetMapping("/invoice-customers")
    public Iterable<InvoiceCustomer> getInvoiceCustomers() {
        return invoiceCustomerService.getInvoiceCustomers();
    }

    @GetMapping("/invoice-customers/{id}")
    public InvoiceCustomer getInvoiceCustomer(@PathVariable("id") final Integer id) {
        Optional<InvoiceCustomer> invoiceCustomer = invoiceCustomerService.getInvoiceCustomer(id);
        if(invoiceCustomer.isPresent()){
            return invoiceCustomer.get();
        } else {
            return null;
        }
    }

    @PostMapping("/invoice-customers")
    public InvoiceCustomer createHouse(@RequestBody InvoiceCustomer invoiceCustomer) {
        return invoiceCustomerService.saveInvoiceCustomer(invoiceCustomer);
    }

    @PutMapping("/invoice-customers/{id}")
    public InvoiceCustomer updateInvoiceCustomer(@PathVariable("id") final Integer id, @RequestBody InvoiceCustomer invoiceCustomer){
        Optional<InvoiceCustomer> i = invoiceCustomerService.getInvoiceCustomer(id);
        if(i.isPresent()){
            InvoiceCustomer currentInvoiceCustomer = i.get();

            Boolean isPaid = invoiceCustomer.isPaid();
            if(isPaid != false){
                currentInvoiceCustomer.setPaid(isPaid);
            }
            invoiceCustomerService.saveInvoiceCustomer(currentInvoiceCustomer);
            return currentInvoiceCustomer;
        } else {
            return null;
        }
    }

    @DeleteMapping("/invoice-customers/{id}")
    public void deleteInvoiceCustomer(@PathVariable("id") final Integer id) {
        invoiceCustomerService.deleteInvoiceCustomer(id);
    }
}
