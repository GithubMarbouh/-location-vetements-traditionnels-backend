package com.marbouh.locationdevetementstraditionnels.services.impl;
import com.marbouh.locationdevetementstraditionnels.model.Location;
import com.marbouh.locationdevetementstraditionnels.model.Produit;
import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import com.marbouh.locationdevetementstraditionnels.repository.ProduitRepository;
import com.marbouh.locationdevetementstraditionnels.repository.ReservationRepository;
import com.marbouh.locationdevetementstraditionnels.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marbouh.locationdevetementstraditionnels.model.CreneauEssayage;
import com.marbouh.locationdevetementstraditionnels.repository.CreneauEssayageRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ReservationServiceImp  {

    ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImp(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ArrayList<Reservation> findAll() {
        return new ArrayList<>(reservationRepository.findAll());
    }

public Reservation findById(int id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> findByProduit_id(int id) {
        return reservationRepository.findByProduit_id(id);
    }

    public List<Reservation> findByProduitAndPeriod(int produit_id, Instant date) {
        return reservationRepository.findByProduitAndPeriod(produit_id, date);
    }
    public List<Location> verify_2(int produit_id, Instant date) {
        return reservationRepository.verify_2(produit_id, date);
    }

    public List<Reservation> findByClientId(int id) {
        return reservationRepository.findByClientId(id);
    }

    public List<Reservation> findByClient(int id) {
        return reservationRepository.findByClient(id);
    }
    public List<Reservation> findNotAccepted(int id) {
        return reservationRepository.findNotAccepted(id);
    }
    public Reservation update(Reservation reservation) {
        return reservationRepository.saveAndFlush(reservation);
    }
}
