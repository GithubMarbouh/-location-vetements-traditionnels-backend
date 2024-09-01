package com.marbouh.locationdevetementstraditionnels.controller;

//import com.example.PFS.DAO.ProduitDAO;
//import com.example.PFS.model.CreneauDisponibilite;
//import com.example.PFS.model.Image;
//import com.example.PFS.model.Produit;
//import com.example.PFS.service.CreneauDisponibiliteService;
//import com.example.PFS.service.ProduitService;
import com.marbouh.locationdevetementstraditionnels.model.CreneauDisponibilite;
import com.marbouh.locationdevetementstraditionnels.model.Image;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.repository.ProduitDAO;
import com.marbouh.locationdevetementstraditionnels.services.impl.CreneauDisponibiliteService;
import com.marbouh.locationdevetementstraditionnels.services.impl.ProduitService;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitDAO produitDAO;
    @Autowired
    private CreneauDisponibiliteService creneauDisponibiliteService;


    @PostMapping(value = {"/ajouterProduit"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Produit ajouterProduit(@RequestPart("produit") Produit produit, @RequestPart("image_produit")MultipartFile[] files ) {
        try {
           Set<Image> images = uploadImage(files);
           produit.setImages(images);
           return produitService.ajouterProduit(produit);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping({"/getAllProduits"})
    public List<Produit> getAllProduits() {
          return produitService.getAllProduits();
    }

    @DeleteMapping({"/supprimerProduit/{ProduitId}"})
    public void supprimerProduit(@PathVariable("ProduitId") Integer ProduitId) {
            produitService.supprimerProduit(ProduitId);
    }

    @PutMapping({"/updateProduit"})
    public Produit updateProduit(@RequestPart("produit") Produit produit, @RequestPart("image_produit")MultipartFile[] files ) {
        try {
            Set<Image> images = uploadImage(files);
            produit.setImages(images);
            return produitService.updateProduit(produit);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

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

    @GetMapping("/getProduitsDispoPourCreneau/{id_creneau}")
    public Set<Produit> getProduitsDispoPourCreneau(@PathVariable Integer id_creneau) {
        return produitService.getProduitsDispoPourCreneau(id_creneau);
    }

    @GetMapping("/getCreneauxPourProduit/{id_produit}")
    public Set<CreneauDisponibilite> getCreneauxPourProduit(@PathVariable Integer id_produit) {
        return produitService.getCreneauxPourProduit(id_produit);
    }


    @GetMapping("/getProduit/{id}")
    public Produit getProduit(@PathVariable Integer id) {
        return produitService.findById(id);
    }

    @GetMapping ("/getSuggestions/{id}")
    public List<Produit> getSuggestions(@PathVariable Integer id) {
        return produitService.findByIdNot(id);
    }
    @GetMapping("/search")
    public List<Produit> search(@RequestParam(defaultValue = "") String mot) {
        return produitService.search(mot);
    }

    @GetMapping("/récent")
    public List<Produit> ProduitRecent() {
        return produitService.ProduitRecent();
    }

}
