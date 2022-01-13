package com.temaintermediara.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Joc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nume;
    private String categorie;
    private String scor;

    public Joc() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getScor() {
        return scor;
    }

    public void setScor(String scor) {
        this.scor = scor;
    }

}
