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

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("SELECT l FROM Reservation l WHERE l.produit.id = :id")
    List<Reservation> findByProduit_id(int id);
    @Query("SELECT l FROM Reservation l WHERE l.produit.id = :produit_id  AND l.date= :date")
    List<Reservation> findByProduitAndPeriod(@Param("produit_id") int produit_id, @Param("date") Instant date);
    @Query("SELECT l FROM Location l WHERE l.produit.id= :produit_id  AND ( :date BETWEEN l.datedebut AND l.datefin)")
    List<Location> verify_2(@Param("produit_id") int produit_id, @Param("date") Instant date);
    @Query("SELECT l FROM Reservation l WHERE l.client.id = :id")
    List<Reservation> findByClientId(int id);
    @Transactional
    @Modifying
    @Query("DELETE FROM Reservation l WHERE l.id = :id")
    void deleteById(int id);
    @Query("SELECT l FROM Reservation l WHERE l.client.id = :id")
    List<Reservation> findByClient(int id);
    @Query("SELECT r FROM Reservation r WHERE r.accepted = false AND r.produit.id_boutique= :id")
    List<Reservation> findNotAccepted(int id);
    @Transactional
    @Modifying
    @Query("DELETE FROM Reservation r WHERE r.client.id = :id")
    void deleteByClientId(int id);

}
