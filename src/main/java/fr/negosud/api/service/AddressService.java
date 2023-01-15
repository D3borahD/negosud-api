package fr.negosud.api.service;

import fr.negosud.api.model.Address;
import fr.negosud.api.repository.AddressRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Iterable<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddress(final Integer id) {
        return addressRepository.findById(id);
    }

    public void deleteAddress(final Integer id) {
        addressRepository.deleteById(id);
    }

    public Address saveAddress(Address address) {
        Address savedAddress = addressRepository.save(address);
        return savedAddress;
    }
}
