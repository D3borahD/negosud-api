package fr.negosud.api.service;

import fr.negosud.api.model.Familly;
import fr.negosud.api.repository.FamillyRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class FamillyService {

    @Autowired
    private FamillyRepository famillyRepository;

    public Iterable<Familly> getFamilly() {
        return famillyRepository.findAll();
    }

    public Optional<Familly> getFamilly(final Integer id) {
        return famillyRepository.findById(id);
    }

    public void deleteFamilly(final Integer id) {
        famillyRepository.deleteById(id);
    }

    public Familly saveFamilly(Familly customer) {
        Familly savedFamilly = famillyRepository.save(customer);
        return savedFamilly;
    }

}
