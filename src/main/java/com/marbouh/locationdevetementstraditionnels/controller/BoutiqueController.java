package com.marbouh.locationdevetementstraditionnels.controller;

import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import com.marbouh.locationdevetementstraditionnels.model.Image;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.model.Utilisateur;
import com.marbouh.locationdevetementstraditionnels.services.impl.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/boutiques")
public class BoutiqueController {
    BoutiqueService boutiqueService;

    @Autowired
    public BoutiqueController(BoutiqueService boutiqueService) {
        this.boutiqueService = boutiqueService;
    }

    @GetMapping()
    List<Boutique> getAll() {
        return boutiqueService.findAll();
    }

    @GetMapping("/{id}")
    Boutique getBoutique(@PathVariable("id") int id) {
        return boutiqueService.findById(id);
    }

    @PostMapping(value={"/createBoutique"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    void createBoutique(@RequestPart("boutique") Boutique boutique, @RequestPart("vendeur")Utilisateur user, @RequestPart("image_boutique") MultipartFile[] files ) {
        try {
            Set<Image> images = uploadImage(files);
            boutique.setImages(images);
            boutique.setId(0);
            boutiqueService.saveOrUpdate(boutique, user);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("/update")
    Boutique updateBoutique(@RequestPart("boutique") Boutique boutique , @RequestPart("image_boutique") MultipartFile[] files) {
        try {
            Set<Image> images = uploadImage(files);
            boutique.setImages(images);
            return boutiqueService.update(boutique);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/delete")
    void delete(@RequestParam("id") int id) {
        boutiqueService.deleteById(id);
    }

    @GetMapping("/{id}/produit")
    List<Produit> getAllProduitsFromBoutique(@PathVariable("id") int id) {
        return boutiqueService.getAllProduitsFromBoutique(id);
    }
    public Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<Image> images = new HashSet<>();
        for(MultipartFile fichier : multipartFiles){
            Image image = new Image(
                    fichier.getName(), fichier.getContentType(), fichier.getBytes());
            images.add(image);
        }
        return images;
    }

    @GetMapping("/vendeur/{id}")
    Boutique getBoutiqueByVendeur(@PathVariable("id") int id) {
        return boutiqueService.getBoutiqueByClient(id);
    }

    @GetMapping("/vendeur/email")
    Integer getBoutiqueIdByVendeurEmail(@RequestParam("email") String email) {
        return boutiqueService.getBoutiqueIdByVendeurEmail(email);
    }
}
