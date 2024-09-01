package com.marbouh.locationdevetementstraditionnels.controller;
import com.marbouh.locationdevetementstraditionnels.model.CreneauEssayage;
import com.marbouh.locationdevetementstraditionnels.services.CreneauEssayageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/creneau-essayage")
public class CreneauEssayageController {
    private final CreneauEssayageService creneauEssayageService;
    private CreneauEssayage creneauEssayage;
    public CreneauEssayageController(CreneauEssayageService creneauEssayageService) {
        this.creneauEssayageService = creneauEssayageService;
    }

    @PostMapping("/add")
    public void addCreneau(@RequestBody CreneauEssayage creneauEssayage) {
        creneauEssayageService.save(creneauEssayage);
    }
    @PutMapping("/update")
    public void updateCreneau(@RequestBody CreneauEssayage creneauEssayage) {
        creneauEssayageService.save(creneauEssayage);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCreneau( @PathVariable Integer id) {
        creneauEssayageService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public CreneauEssayage findCreneau(@PathVariable Integer id) {
       return creneauEssayageService.findById(id);
    }
    @GetMapping("/findAll")
    public List<CreneauEssayage> findAllCreneau() {
       return creneauEssayageService.findAll();
    }

}
