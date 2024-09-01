package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.faces.event.WebsocketEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "creneau_essayage")
public class CreneauEssayage extends AbstractEntity{
      @Column(name = "date")
      private Instant date ;
      @Column(name = "heure_debut")
      private Time heureDebut;
      @Column(name = "heure_fin")
      private Time heureFin;


}
