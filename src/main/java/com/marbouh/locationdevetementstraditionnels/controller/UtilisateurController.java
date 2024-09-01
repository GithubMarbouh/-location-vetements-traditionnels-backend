package com.marbouh.locationdevetementstraditionnels.controller;


import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.services.impl.UtilisateurServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UtilisateurController {
    private final UtilisateurServiceImpl utilisateurService;

    @PutMapping("/update")
    public Utilisateur Update(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.update(utilisateur);
    }
    @DeleteMapping("/client/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        utilisateurService.deleteById(id);
    }
    @GetMapping("/clients")
    public List<Utilisateur> getAllClient() {
        return utilisateurService.getAllClient();
    }
}

