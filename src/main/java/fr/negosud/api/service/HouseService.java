package fr.negosud.api.service;

import fr.negosud.api.model.House;
import fr.negosud.api.repository.HouseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public Iterable<House> getHouse() {
        return houseRepository.findAll();
    }

    public Optional<House> getHouse(final Integer id) {
        return houseRepository.findById(id);
    }

    public void deleteHouse(final Integer id) {
        houseRepository.deleteById(id);
    }

    public House saveHouse(House house) {
        House savedHouse = houseRepository.save(house);
        return savedHouse;
    }
}
