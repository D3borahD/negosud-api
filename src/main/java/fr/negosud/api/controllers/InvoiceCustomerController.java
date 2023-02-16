package fr.negosud.api.controllers;

import fr.negosud.api.model.InvoiceCustomer;
import fr.negosud.api.service.InvoiceCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InvoiceCustomerController {

    @Autowired
    private InvoiceCustomerService invoiceCustomerService;

    @GetMapping("/factureClients")
    public Iterable<InvoiceCustomer> getInvoiceCustomers() {
        return invoiceCustomerService.getInvoiceCustomers();
    }

    @GetMapping("/factureClients/{id}")
    public InvoiceCustomer getInvoiceCustomer(@PathVariable("id") final Integer id) {
        Optional<InvoiceCustomer> invoiceCustomer = invoiceCustomerService.getInvoiceCustomer(id);
        if(invoiceCustomer.isPresent()){
            return invoiceCustomer.get();
        } else {
            return null;
        }
    }

    @PostMapping("/factureClients")
    public InvoiceCustomer createHouse(@RequestBody InvoiceCustomer invoiceCustomer) {
        return invoiceCustomerService.saveInvoiceCustomer(invoiceCustomer);
    }

    @PutMapping("/factureClients/{id}")
    public InvoiceCustomer updateInvoiceCustomer(@PathVariable("id") final Integer id, @RequestBody InvoiceCustomer invoiceCustomer){
        Optional<InvoiceCustomer> i = invoiceCustomerService.getInvoiceCustomer(id);
        if(i.isPresent()){
            InvoiceCustomer currentInvoiceCustomer = i.get();

            String statusInvoiceCustomer = invoiceCustomer.getStatus();
            if(statusInvoiceCustomer != null){
                currentInvoiceCustomer.setStatus(statusInvoiceCustomer);
            }
            int idOrder = invoiceCustomer.getIdOrder();
            if(idOrder != 0){
                currentInvoiceCustomer.setIdOrder(idOrder);
            }
            invoiceCustomerService.saveInvoiceCustomer(currentInvoiceCustomer);
            return currentInvoiceCustomer;
        } else {
            return null;
        }
    }

    @DeleteMapping("/factureClients/{id}")
    public void deleteInvoiceCustomer(@PathVariable("id") final Integer id) {
        invoiceCustomerService.deleteInvoiceCustomer(id);
    }
}
