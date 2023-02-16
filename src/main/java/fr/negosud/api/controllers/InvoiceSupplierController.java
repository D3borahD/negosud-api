package fr.negosud.api.controllers;

import fr.negosud.api.model.InvoiceSupplier;
import fr.negosud.api.service.InvoiceSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InvoiceSupplierController {

    @Autowired
    private InvoiceSupplierService invoiceSupplierService;

    @GetMapping("/factureFournisseurs")
    public Iterable<InvoiceSupplier> getInvoiceSuppliers() {
        return invoiceSupplierService.getInvoiceSuppliers();
    }

    @GetMapping("/factureFournisseurs/{id}")
    public InvoiceSupplier getInvoiceSupplier(@PathVariable("id") final Integer id) {
        Optional<InvoiceSupplier> invoiceSupplier = invoiceSupplierService.getInvoiceSupplier(id);
        if(invoiceSupplier.isPresent()){
            return invoiceSupplier.get();
        } else {
            return null;
        }
    }


    @PostMapping("/factureFournisseurs")
    public InvoiceSupplier createHouse(@RequestBody InvoiceSupplier invoiceSupplier) {
        return invoiceSupplierService.saveInvoiceSupplier(invoiceSupplier);
    }

    @PutMapping("/factureFournisseurs/{id}")
    public InvoiceSupplier updateInvoiceSupplier(@PathVariable("id") final Integer id, @RequestBody InvoiceSupplier invoiceSupplier){
        Optional<InvoiceSupplier> i = invoiceSupplierService.getInvoiceSupplier(id);
        if(i.isPresent()){
            InvoiceSupplier currentInvoiceSupplier = i.get();

           Boolean isPaid = invoiceSupplier.isPaid();
            if(isPaid != false){
                currentInvoiceSupplier.setPaid(isPaid);
            }
            invoiceSupplierService.saveInvoiceSupplier(currentInvoiceSupplier);
            return currentInvoiceSupplier;
        } else {
            return null;
        }
    }

    @DeleteMapping("/factureFournisseurs/{id}")
    public void deleteInvoiceSupplier(@PathVariable("id") final Integer id) {
        invoiceSupplierService.deleteInvoiceSupplier(id);
    }
}
