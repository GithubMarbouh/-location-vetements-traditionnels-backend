package com.marbouh.locationdevetementstraditionnels.repository;

import com.marbouh.locationdevetementstraditionnels.model.Location;
import com.marbouh.locationdevetementstraditionnels.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Integer> {
        @Query("SELECT l FROM Location l WHERE l.produit.id = :id")
        List<Location> findByProduit_id(@Param("id") int id);
        @Query("SELECT l FROM Location l WHERE l.produit.id = :produit_id AND ((l.datedebut BETWEEN :datedebut AND :datefin) OR (l.datefin BETWEEN :datedebut AND :datefin))")
        List<Location> findByProduitAndPeriod(@Param("produit_id") int produit_id, @Param("datedebut") Instant datedebut, @Param("datefin") Instant datefin);
        @Query("SELECT l FROM Reservation l WHERE l.produit.id= :produit_id  AND (l.date BETWEEN :datedebut AND :datefin)")
        List<Reservation> verify_2(@Param("produit_id") int produit_id, @Param("datedebut") Instant datedebut, @Param("datefin") Instant datefin);
        @Query("SELECT l FROM Location l WHERE l.client.id = :id")
        List<Location> findByClientId(int id);
        @Transactional
        @Modifying
        @Query("DELETE FROM Location l WHERE l.id = :id")
        void deleteById(int id);
        @Query("SELECT l FROM Location l WHERE l.accepted = false AND l.produit.id_boutique= :id")
        List<Location> findNotAccepted(int id);
        @Transactional
        @Modifying
        @Query("DELETE FROM Location l WHERE l.client.id = :id")
        void deleteByClientId(int id);

}
