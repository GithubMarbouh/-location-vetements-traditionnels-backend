package com.marbouh.locationdevetementstraditionnels.controller;

import com.marbouh.locationdevetementstraditionnels.model.Location;
import com.marbouh.locationdevetementstraditionnels.model.Boutique;
import com.marbouh.locationdevetementstraditionnels.model.Client;
import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import com.marbouh.locationdevetementstraditionnels.services.impl.LocationService;
import com.marbouh.locationdevetementstraditionnels.services.impl.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;
    private BoutiqueService boutiqueService;


    @GetMapping("/location")
    List<Location> getAll() {
        return locationService.findAll();
    }

    @GetMapping("/location/")
    Location getLocation(@RequestParam("id") int id) {
        return locationService.findById(id);
    }

    @PostMapping("/location/create")
    Location createLocation(@RequestBody Location location) {
        locationService.saveOrUpdate(location);
        return( location);

    }

    @DeleteMapping("/location/delete/{id}")
    void delete(@PathVariable("id") int id) {
        locationService.deleteById(id);
    }

    @GetMapping("/location/produit/{id}")
    List<Location> findByProduit_id(@PathVariable("id") int id) {
        return locationService.findByProduit_id(id);
    }

    @GetMapping("/location/verify")
    List<Location> findByProduitAndPeriod(@RequestParam("produit_id") int produit_id, @RequestParam("datedebut") Instant datedebut, @RequestParam("datefin") Instant datefin) {
        return locationService.findByProduitAndPeriod(produit_id, datedebut, datefin);
    }
    @GetMapping("/location/verify_2")
    List<Reservation> verify_2(@RequestParam("produit_id") int produit_id, @RequestParam("datedebut") Instant datedebut, @RequestParam("datefin") Instant datefin) {
        return locationService.verify_2(produit_id, datedebut, datefin);
    }
    @GetMapping("/location/client/{id}")
    List<Location> findByClientId(@PathVariable("id") int id) {
        return locationService.findByClientId(id);
    }

    @GetMapping("/location/attente/{id}")
    List<Location> findNotAccepted(@PathVariable("id") int id) {
        return locationService.findNotAccepted(id);
    }
    @PutMapping("/location/update")
    Location updateLocation1(@RequestBody Location location) {
        Location existingLocation = locationService.findById(location.getId());
        if (existingLocation != null) {
            existingLocation.setAccepted(true);
            return locationService.update(existingLocation);
        } else {
            return null;
        }
    }

}
