package fr.negosud.api.controllers;


import fr.negosud.api.model.Familly;
import fr.negosud.api.service.FamillyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FamillyController {

    @Autowired
    private FamillyService famillyService;

    @GetMapping("/familles")
    public Iterable<Familly> getFamilly() {
        return famillyService.getFamilly();
    }

    @GetMapping("/familles/{id}")
    public Familly getFamilly(@PathVariable("id") final Integer id) {
        Optional<Familly> familly = famillyService.getFamilly(id);
        if(familly.isPresent()){
            return familly.get();
        } else {
            return null;
        }
    }

    @PostMapping("/familles")
    public Familly createFamilly(@RequestBody Familly familly) {
        return famillyService.saveFamilly(familly);
    }

    @PutMapping("familles/{id}")
    public Familly updateFamilly(@PathVariable("id") final Integer id, @RequestBody Familly familly){
        Optional<Familly> f = famillyService.getFamilly(id);
        if(f.isPresent()){
            Familly currentFamilly = f.get();

            String nameFamilly = familly.getNameFamilly();
            if(nameFamilly != null){
                currentFamilly.setNameFamilly(nameFamilly);
            }

            famillyService.saveFamilly(currentFamilly);
            return currentFamilly;
        } else {
            return null;
        }
    }

    @DeleteMapping("familles/{id}")
    public void deleteFamilly(@PathVariable("id") final Integer id) {
        famillyService.deleteFamilly(id);
    }

}
