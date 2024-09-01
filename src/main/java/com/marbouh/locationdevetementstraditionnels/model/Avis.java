package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "avis")
@Data
public class Avis  extends AbstractEntity {

    private int note;
    private String commentaire;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //    @Column(name = "id_avis")
//
//    private Long id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_client")
    private Utilisateur client;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "boutique_id")
    private Boutique boutique;

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public int getNote() {
//        return note;
//    }
//
//    public void setNote(int note) {
//        this.note = note;
//    }
//
//    public String getCommentaire() {
//        return commentaire;
//    }
//
//    public void setCommentaire(String commentaire) {
//        this.commentaire = commentaire;
//    }
//
//    public Boutique getBoutique() {
//        return boutique;
//    }
//
//    public void setBoutique(Boutique boutique) {
//        this.boutique = boutique;
//    }



}