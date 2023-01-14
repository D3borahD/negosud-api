package fr.negosud.api.controllers;

import fr.negosud.api.model.Familly;
import fr.negosud.api.model.Provider;
import fr.negosud.api.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/fournisseurs")
    public Iterable<Provider> getProvider() {
        return providerService.getProviders();
    }

    @GetMapping("/fournisseurs/{id}")
    public Provider getProvider(@PathVariable("id") final Integer id) {
        Optional<Provider> provider = providerService.getProvider(id);
        if(provider.isPresent()){
            return provider.get();
        } else {
            return null;
        }
    }

    @PostMapping("/fournisseurs")
    public Provider createProvider(@RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    @PutMapping("fournisseurs/{id}")
    public Provider updateProvider(@PathVariable("id")
                                       final Integer id, @RequestBody Provider provider){
        Optional<Provider> f = providerService.getProvider(id);
        if(f.isPresent()){
            Provider currentProvider = f.get();

            String nameProvider= provider.getNameProvider();
            if(nameProvider != null){
                currentProvider.setNameProvider(nameProvider);
            }

            providerService.saveProvider(currentProvider);
            return currentProvider;
        } else {
            return null;
        }
    }

    @DeleteMapping("fournisseurs/{id}")
    public void deleteProvider(@PathVariable("id") final Integer id) {
        providerService.deleteProvider(id);
    }

}
