package com.biprom.amcal.amcalpompen.Entities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.annotation.Id;

public class Product {

    @Id
    String index;

    Integer aantal;
    Integer aantalGebruikt;
    String omschrijvingArtikelFabrikant;
    String omschrijvingArtikelAmccal;
    String artikelNummer;
    String eANNummer;
    Boolean artikelGebruikt;
    String linkGrundfos;
    Double gewichtArtikel;
    Double bruto2018;
    String prijsGroep2018;
    Double korting;

    public Product(Integer aantal) {
        this.aantal = aantal;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    public Integer getAantalGebruikt() {
        return aantalGebruikt;
    }

    public void setAantalGebruikt(Integer aantalGebruikt) {
        this.aantalGebruikt = aantalGebruikt;
    }

    public String getOmschrijvingArtikelFabrikant() {
        return omschrijvingArtikelFabrikant;
    }

    public void setOmschrijvingArtikelFabrikant(String omschrijvingArtikelFabrikant) {
        this.omschrijvingArtikelFabrikant = omschrijvingArtikelFabrikant;
    }

    public String getOmschrijvingArtikelAmccal() {
        return omschrijvingArtikelAmccal;
    }

    public void setOmschrijvingArtikelAmccal(String omschrijvingArtikelAmccal) {
        this.omschrijvingArtikelAmccal = omschrijvingArtikelAmccal;
    }

    public String getArtikelNummer() {
        return artikelNummer;
    }

    public void setArtikelNummer(String artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    public String geteANNummer() {
        return eANNummer;
    }

    public void seteANNummer(String eANNummer) {
        this.eANNummer = eANNummer;
    }

    public Boolean getArtikelGebruikt() {
        return artikelGebruikt;
    }

    public void setArtikelGebruikt(Boolean artikelGebruikt) {
        this.artikelGebruikt = artikelGebruikt;
    }

    public String getLinkGrundfos() {
        return linkGrundfos;
    }

    public void setLinkGrundfos(String linkGrundfos) {
        this.linkGrundfos = linkGrundfos;
    }

    public Double getGewichtArtikel() {
        return gewichtArtikel;
    }

    public void setGewichtArtikel(Double gewichtArtikel) {
        this.gewichtArtikel = gewichtArtikel;
    }

    public Double getBruto2018() {
        return bruto2018;
    }

    public void setBruto2018(Double bruto2018) {
        this.bruto2018 = bruto2018;
    }

    public String getPrijsGroep2018() {
        return prijsGroep2018;
    }

    public void setPrijsGroep2018(String prijsGroep2018) {
        this.prijsGroep2018 = prijsGroep2018;
    }

    public Double getKorting() {
        return korting;
    }

    public void setKorting(Double korting) {
        this.korting = korting;
    }
}
