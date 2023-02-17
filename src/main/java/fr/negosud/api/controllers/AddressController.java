package fr.negosud.api.controllers;

import fr.negosud.api.model.Address;
import fr.negosud.api.model.AdresseType;
import fr.negosud.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/adresses")
    public Iterable<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("/adresses/{id}")
    public Address getAddress(@PathVariable("id") final Integer id) {
        Optional<Address> address = addressService.getAddress(id);
        if(address.isPresent()){
            return address.get();
        } else {
            return null;
        }
    }

    @PostMapping("/adresses")
    public Address createAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("adresses/{id}")
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

    @DeleteMapping("adresses/{id}")
    public void deleteAddress(@PathVariable("id") final Integer id) {
        addressService.deleteAddress(id);
    }

}
