package com.biprom.amcal.amcalpompen.Entities;

import org.springframework.data.annotation.Id;

public class Adres {

    @Id
    private String Id;

    private String land;
    private String stad;
    private String straat;
    private String nummer;
    private String postcode;
    private String bus;
    private String commentaar;

    public Adres(String land, String stad, String straat, String nummer, String postcode, String bus, String commentaar) {
        this.land = land;
        this.stad = stad;
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
        this.bus = bus;
        this.commentaar = commentaar;
    }

    public Adres() {
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getCommentaar() {
        return commentaar;
    }

    public void setCommentaar(String commentaar) {
        this.commentaar = commentaar;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "Id='" + Id + '\'' +
                ", land='" + land + '\'' +
                ", stad='" + stad + '\'' +
                ", straat='" + straat + '\'' +
                ", nummer='" + nummer + '\'' +
                ", postcode='" + postcode + '\'' +
                ", bus='" + bus + '\'' +
                ", commentaar='" + commentaar + '\'' +
                '}';
    }
}
