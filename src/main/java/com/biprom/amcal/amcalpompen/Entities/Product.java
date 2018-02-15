package com.biprom.amcal.amcalpompen.Entities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.annotation.Id;

public class Product {

    @Id
    String id;

    Integer aantalGebruikt;
    String artikelNummer;
    String EANNummer;
    Double gewichtArtikel;
    String linkGrudfos;
    String omschrijvingArtikelFabrikant;
    String omschrijvingArtikelAmccal;
    Boolean artikelGebruikt;
    Double bruto2018;
    String prijsGroep2018;
    Double korting;


    public Integer getAantal() {
        return aantalGebruikt;
    }

    public void setAantal(Integer aantal) {
        this.aantalGebruikt = aantal;
    }

    public String getArtikelNummer() {
        return artikelNummer;
    }

    public void setArtikelNummer(String artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    public String getEANNummer() {
        return EANNummer;
    }

    public void setEANNummer(String EANNummer) {
        this.EANNummer = EANNummer;
    }

    public Double getGewichtArtikel() {
        return gewichtArtikel;
    }

    public void setGewichtArtikel(Double gewichtArtikel) {
        this.gewichtArtikel = gewichtArtikel;
    }

    public String getLinkGrudfos() {
        return linkGrudfos;
    }

    public void setLinkGrudfos(String linkGrudfos) {
        this.linkGrudfos = linkGrudfos;
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

    public Boolean getArtikelGebruikt() {
        return artikelGebruikt;
    }

    public void setArtikelGebruikt(Boolean artikelGebruikt) {
        this.artikelGebruikt = artikelGebruikt;
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
