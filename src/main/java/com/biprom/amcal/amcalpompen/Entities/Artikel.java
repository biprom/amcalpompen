package com.biprom.amcal.amcalpompen.Entities;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

public class Artikel {

    @Id
    String Id;

    //Hoofdgegevens
    private String artikelCode;
    private String eANNummer;
    private Integer stockAantal;
    private Integer aantalGebruikt;
    private String bulkNummer;
    private int aantalInBulk;
    private String commentaarToevoeging;
    private  String omschrijvingArtikelFabrikant;
    private String  getOmschrijvingArtikelAmcal;
    private boolean artikelGebruikt;
    private String linkGrundfoss;
    private  double gewichtArtikel;
    private double brutoPrijs2018;
    private String prijsGroep2018;
    private double korting;


    //TypeGegevens
    private List<String> artikelType;
    private List<String>  pompType;

    //DetailGegevens
    private List<String>  asAfdichting;
    private List<String>  kitSlijtdelen;
    private List<String>  pompKapVoet;
    private List<String>  kitORingen;
    private List<String>  kitWaaiersKamer;
    private List<String>  mantelTrekstangTreklatPompas;
    private List<String>  allerlei;


    public String getArtikelCode() {
        return artikelCode;
    }

    public void setArtikelCode(String artikelCode) {
        this.artikelCode = artikelCode;
    }

    public Integer getStockAantal() {
        return stockAantal;
    }

    public void setStockAantal(Integer stockAantal) {
        this.stockAantal = stockAantal;
    }

    public String getBulkNummer() {
        return bulkNummer;
    }

    public void setBulkNummer(String bulkNummer) {
        this.bulkNummer = bulkNummer;
    }

    public int getAantalInBulk() {
        return aantalInBulk;
    }

    public void setAantalInBulk(int aantalInBulk) {
        this.aantalInBulk = aantalInBulk;
    }

    public String getCommentaarToevoeging() {
        return commentaarToevoeging;
    }

    public void setCommentaarToevoeging(String commentaarToevoeging) {
        this.commentaarToevoeging = commentaarToevoeging;
    }

    public List<String> getArtikelType() {
        return artikelType;
    }

    public void setArtikelType(List<String> artikelType) {
        this.artikelType = artikelType;
    }

    public List<String> getPompType() {
        return pompType;
    }

    public void setPompType(List<String> pompType) {
        this.pompType = pompType;
    }

    public List<String> getAsAfdichting() {
        return asAfdichting;
    }

    public void setAsAfdichting(List<String> asAfdichting) {
        this.asAfdichting = asAfdichting;
    }

    public List<String> getKitSlijtdelen() {
        return kitSlijtdelen;
    }

    public void setKitSlijtdelen(List<String> kitSlijtdelen) {
        this.kitSlijtdelen = kitSlijtdelen;
    }

    public List<String> getPompKapVoet() {
        return pompKapVoet;
    }

    public void setPompKapVoet(List<String> pompKapVoet) {
        this.pompKapVoet = pompKapVoet;
    }

    public List<String> getKitORingen() {
        return kitORingen;
    }

    public void setKitORingen(List<String> kitORingen) {
        this.kitORingen = kitORingen;
    }

    public List<String> getKitWaaiersKamer() {
        return kitWaaiersKamer;
    }

    public void setKitWaaiersKamer(List<String> kitWaaiersKamer) {
        this.kitWaaiersKamer = kitWaaiersKamer;
    }

    public List<String> getMantelTrekstangTreklatPompas() {
        return mantelTrekstangTreklatPompas;
    }

    public void setMantelTrekstangTreklatPompas(List<String> mantelTrekstangTreklatPompas) {
        this.mantelTrekstangTreklatPompas = mantelTrekstangTreklatPompas;
    }

    public List<String> getAllerlei() {
        return allerlei;
    }

    public void setAllerlei(List<String> allerlei) {
        this.allerlei = allerlei;
    }
}
