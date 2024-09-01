package com.marbouh.locationdevetementstraditionnels.services.impl;

import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import com.marbouh.locationdevetementstraditionnels.repository.LocationRepository;
import com.marbouh.locationdevetementstraditionnels.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public ArrayList<Location> findAll() {
        return new ArrayList<>(locationRepository.findAll());
    }

    public Location findById(int id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.orElse(null);
    }

    public void saveOrUpdate(Location location) {
        locationRepository.save(location);
    }

    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }

    public List<Location> findByProduit_id(int id) {
        return locationRepository.findByProduit_id(id);
    }

    public List<Location> findByProduitAndPeriod(int produit_id, Instant datedebut, Instant datefin) {
        return locationRepository.findByProduitAndPeriod(produit_id, datedebut, datefin);
    }
    public List<Reservation> verify_2(int produit_id, Instant datedebut, Instant datefin) {
        return locationRepository.verify_2(produit_id, datedebut, datefin);
    }
    public List<Location> findByClientId(int id) {
        return locationRepository.findByClientId(id);
    }
    public List<Location> findNotAccepted(int id) {
        return locationRepository.findNotAccepted(id);
    }
    public Location update(Location location) {
        return locationRepository.saveAndFlush(location);
    }
}

