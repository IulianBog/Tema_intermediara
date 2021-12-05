package com.temaintermediara.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Jocuri {

    @Id
    private String id;
    private String nume;
    private String categorie;
    private String scor;

    public Jocuri() {}

    public String getId() {
        return id;}

    public void setId(String id) {
        this.id = id;}

    public String getNume() {
        return nume;}

    public void setNume(String nume) {
        this.nume = nume;}

    public String getCategorie() {
        return categorie;}

    public void setCategorie(String categorie) {
        this.categorie = categorie;}

    public String getScor() {
        return scor;}

    public void setScor(String scor) {
        this.scor = scor;}
}