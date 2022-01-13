package com.temaintermediara.main.model;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
public class Campionat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nume;
    private String categorie;
    private String map;

    public Campionat() {
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

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tichete_id", referencedColumnName = "id")
    private Tichete tichete;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;


}
