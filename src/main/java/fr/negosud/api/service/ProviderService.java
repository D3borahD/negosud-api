package fr.negosud.api.service;

import fr.negosud.api.model.Provider;
import fr.negosud.api.repository.ProviderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public Iterable<Provider> getProviders() {
        return providerRepository.findAll();
    }

    public Optional<Provider> getProvider(Integer id) {
        return providerRepository.findById(id);
    }

    public void deleteProvider(final Integer id) {
        providerRepository.deleteById(id);
    }

    public Provider saveProvider(Provider provider) {
        Provider savedProvider = providerRepository.save(provider);
        return savedProvider;
    }

}
