package com.marbouh.locationdevetementstraditionnels.services;

import com.marbouh.locationdevetementstraditionnels.model.Reservation;

import java.util.List;

public interface ReservationService {
    void reserver(Reservation reservation);
    void modifierReservation(Reservation reservation);
    void annulerReservation(int idReservation);
    void validerReservation(int idUtilisateur, int idArticle);
    void refuserReservation(int idUtilisateur, int idArticle);
    void retirerReservation(int idUtilisateur, int idArticle);
    void retirerToutesReservations(int idUtilisateur);
    void retirerToutesReservations();
    void validerToutesReservations();
    void refuserToutesReservations();
    void retirerToutesReservationsValidees();
    void retirerToutesReservationsRefusees();
    void retirerToutesReservationsEnAttente();
    void retirerToutesReservationsRetirees();
    List<Reservation> getReservationsByUser(int idUtilisateur);
    List<Reservation> getReservations();

}
