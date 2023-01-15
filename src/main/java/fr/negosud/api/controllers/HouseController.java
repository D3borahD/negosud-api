package fr.negosud.api.controllers;

import fr.negosud.api.model.House;
import fr.negosud.api.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping("/maisons")
    public Iterable<House> getHouse() {
        return houseService.getHouse();
    }

    @GetMapping("/maisons/{id}")
    public House getHouse(@PathVariable("id") final Integer id) {
        Optional<House> house = houseService.getHouse(id);
        if(house.isPresent()){
            return house.get();
        } else {
            return null;
        }
    }

    @PostMapping("/maisons")
    public House createHouse(@RequestBody House house) {
        return houseService.saveHouse(house);
    }

    @PutMapping("maisons/{id}")
    public House updateHouse(@PathVariable("id") final Integer id, @RequestBody House house){
        Optional<House> h = houseService.getHouse(id);
        if(h.isPresent()){
            House currentHouse = h.get();

            String nameHouse = house.getNameHouse();
            if(nameHouse != null){
                currentHouse.setNameHouse(nameHouse);
            }

            houseService.saveHouse(currentHouse);
            return currentHouse;
        } else {
            return null;
        }
    }

    @DeleteMapping("houses/{id}")
    public void deleteHouse(@PathVariable("id") final Integer id) {
        houseService.deleteHouse(id);
    }
}
