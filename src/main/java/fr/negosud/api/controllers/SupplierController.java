package fr.negosud.api.controllers;

import fr.negosud.api.model.Supplier;
import fr.negosud.api.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public Iterable<Supplier> getSuppliers() {
        return supplierService.getSuppliers();
    }

    @GetMapping("/suppliers/{id}")
    public Supplier getSupplier(@PathVariable("id") final Integer id) {
        Optional<Supplier> supplier = supplierService.getSupplier(id);
        if(supplier.isPresent()){
            return supplier.get();
        } else {
            return null;
        }
    }

    @PostMapping("/suppliers")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @PutMapping("suppliers/{id}")
    public Supplier updateSupplier(@PathVariable("id") final Integer id, @RequestBody Supplier supplier){
        Optional<Supplier> s = supplierService.getSupplier(id);
        if(s.isPresent()){
            Supplier currentSupplier = s.get();

            String nameSupplier= supplier.getNameSupplier();
            if(nameSupplier != null){
                currentSupplier.setNameSupplier(nameSupplier);
            }
            String mailSupplier= supplier.getMailSupplier();
            if(mailSupplier != null){
                currentSupplier.setMailSupplier(mailSupplier);
            }
            supplierService.saveSupplier(currentSupplier);
            return currentSupplier;
        } else {
            return null;
        }
    }

    @DeleteMapping("suppliers/{id}")
    public void deleteSupplier(@PathVariable("id") final Integer id) {
        supplierService.deleteSupplier(id);
    }

}
