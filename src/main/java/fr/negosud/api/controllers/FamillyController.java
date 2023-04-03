package fr.negosud.api.controllers;


import fr.negosud.api.model.Familly;
import fr.negosud.api.service.FamillyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FamillyController {

    @Autowired
    private FamillyService famillyService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/families")
    public Iterable<Familly> getFamilly() {
        return famillyService.getFamillys();
    }

    @GetMapping("/families/{id}")
    public Familly getFamilly(@PathVariable("id") final Integer id) {
        Optional<Familly> familly = famillyService.getFamilly(id);
        if(familly.isPresent()){
            return familly.get();
        } else {
            return null;
        }
    }

    @PostMapping("/families")
    public Familly createFamilly(@RequestBody Familly familly) {
        return famillyService.saveFamilly(familly);
    }

    @PutMapping("families/{id}")
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

    @DeleteMapping("families/{id}")
    public void deleteFamilly(@PathVariable("id") final Integer id) {
        famillyService.deleteFamilly(id);
    }

}
