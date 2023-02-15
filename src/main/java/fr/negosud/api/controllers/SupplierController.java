package fr.negosud.api.controllers;

import fr.negosud.api.model.Supplier;
import fr.negosud.api.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/fournisseurs")
    public Iterable<Supplier> getSuppliers() {
        return supplierService.getSuppliers();
    }

    @GetMapping("/fournisseurs/{id}")
    public Supplier getSupplier(@PathVariable("id") final Integer id) {
        Optional<Supplier> supplier = supplierService.getSupplier(id);
        if(supplier.isPresent()){
            return supplier.get();
        } else {
            return null;
        }
    }

    @PostMapping("/fournisseurs")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @PutMapping("fournisseurs/{id}")
    public Supplier updateSupplier(@PathVariable("id") final Integer id, @RequestBody Supplier supplier){
        Optional<Supplier> s = supplierService.getSupplier(id);
        if(s.isPresent()){
            Supplier currentSupplier = s.get();

            String nameSupplier= supplier.getNameSupplier();
            if(nameSupplier != null){
                currentSupplier.setNameSupplier(nameSupplier);
            }

            supplierService.saveSupplier(currentSupplier);
            return currentSupplier;
        } else {
            return null;
        }
    }

    @DeleteMapping("fournisseurs/{id}")
    public void deleteSupplier(@PathVariable("id") final Integer id) {
        supplierService.deleteSupplier(id);
    }

}
