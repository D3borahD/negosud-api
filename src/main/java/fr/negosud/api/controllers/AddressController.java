package fr.negosud.api.controllers;

import fr.negosud.api.model.Address;
import fr.negosud.api.model.AdresseType;
import fr.negosud.api.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public Iterable<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("/addresses/{id}")
    public Address getAddress(@PathVariable("id") final Integer id) {
        Optional<Address> address = addressService.getAddress(id);
        if(address.isPresent()){
            return address.get();
        } else {
            return null;
        }
    }

    @PostMapping("/addresses")
    public Address createAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("addresses/{id}")
    public Address updateAddress(@PathVariable("id") final Integer id, @RequestBody Address address){
        Optional<Address> a = addressService.getAddress(id);
        if(a.isPresent()){
            Address currentAddress = a.get();

            AdresseType type = address.getType();
            if(type != null){
                currentAddress.setType(type);
            }
            String number = address.getNumber();
            if(number != null) {
                currentAddress.setNumber(number);
            }

            String customerFirstname = address.getCustomerFirstname();
            if(customerFirstname != null) {
                currentAddress.setNumber(customerFirstname);
            }
            String customerLastname = address.getCustomerLastname();
            if(customerLastname != null) {
                currentAddress.setNumber(customerLastname);
            }
            String streetName = address.getStreetName();
            if(streetName != null) {
                currentAddress.setStreetName(streetName);
            }
            String zip = address.getZip();
            if(zip != null){
                currentAddress.setZip(zip);
            }
            String city = address.getCity();
            if(city != null) {
                currentAddress.setCity(city);
            }
            String additional = address.getAdditional();
            if(additional != null) {
                currentAddress.setAdditional(additional);
            }
            addressService.saveAddress(currentAddress);
            return currentAddress;
        } else {
            return null;
        }
    }

    @DeleteMapping("addresses/{id}")
    public void deleteAddress(@PathVariable("id") final Integer id) {
        addressService.deleteAddress(id);
    }

}
