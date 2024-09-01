package com.marbouh.locationdevetementstraditionnels.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="image")
public class Image extends AbstractEntity{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_image;
    private String name;
    private String type;
    @Column(length = 50000000)
    private byte[] picByte;

    public Image() {
    }

    public Image(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

//    public Integer getId() {
//        return id_image;
//    }
//
//    public void setId(Integer id) {
//        this.id_image = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
