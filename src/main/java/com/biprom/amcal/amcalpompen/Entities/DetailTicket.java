package com.biprom.amcal.amcalpompen.Entities;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import sun.security.krb5.internal.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


@SpringComponent

public class DetailTicket {

    @Id
    private String Id;

    private String artikelNummerInstallatie;
    private Integer installatieJaar;
    private Integer installatieWeek;
    private String omschrijvingInstallatie;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime detailAanmaakDatum;


    private String artikelNummerPomp;
    private Integer jaarPomp;
    private Integer weekPomp;
    private String omschrijvingPomp;

    private ArrayList<Product> benodigdheden = new ArrayList<Product>();

    private String vaststellingTechnieker;
    private String interneOpmerkingen;

    private ArrayList<WerkUren> werkUren = new ArrayList<WerkUren>();

    private int ramingUren;

    private boolean opdrachtAfgewerkt;
    private boolean tussentijdseFacturatieMogelijk;
    private boolean verderInTePlannen;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getArtikelNummerInstallatie() {
        return artikelNummerInstallatie;
    }

    public void setArtikelNummerInstallatie(String artikelNummerInstallatie) {
        this.artikelNummerInstallatie = artikelNummerInstallatie;
    }

    public Integer getInstallatieJaar() {
        return installatieJaar;
    }

    public void setInstallatieJaar(Integer installatieJaar) {
        this.installatieJaar = installatieJaar;
    }

    public Integer getInstallatieWeek() {
        return installatieWeek;
    }

    public void setInstallatieWeek(Integer installatieWeek) {
        this.installatieWeek = installatieWeek;
    }

    public String getOmschrijvingInstallatie() {
        return omschrijvingInstallatie;
    }

    public void setOmschrijvingInstallatie(String omschrijvingInstallatie) {
        this.omschrijvingInstallatie = omschrijvingInstallatie;
    }

    public String getArtikelNummerPomp() {
        return artikelNummerPomp;
    }

    public void setArtikelNummerPomp(String artikelNummerPomp) {
        this.artikelNummerPomp = artikelNummerPomp;
    }

    public Integer getJaarPomp() {
        return jaarPomp;
    }

    public void setJaarPomp(Integer jaarPomp) {
        this.jaarPomp = jaarPomp;
    }

    public Integer getWeekPomp() {
        return weekPomp;
    }

    public void setWeekPomp(Integer weekPomp) {
        this.weekPomp = weekPomp;
    }

    public String getOmschrijvingPomp() {
        return omschrijvingPomp;
    }

    public void setOmschrijvingPomp(String omschrijvingPomp) {
        this.omschrijvingPomp = omschrijvingPomp;
    }

    public ArrayList<Product> getBenodigdheden() {
        return benodigdheden;
    }

    public void setBenodigdheden(ArrayList<Product> benodigdheden) {
        this.benodigdheden = benodigdheden;
    }

    public String getVaststellingTechnieker() {
        return vaststellingTechnieker;
    }

    public void setVaststellingTechnieker(String vaststellingTechnieker) {
        this.vaststellingTechnieker = vaststellingTechnieker;
    }

    public String getInterneOpmerkingen() {
        return interneOpmerkingen;
    }

    public void setInterneOpmerkingen(String interneOpmerkingen) {
        this.interneOpmerkingen = interneOpmerkingen;
    }

    public ArrayList<WerkUren> getWerkUren() {
        return werkUren;
    }

    public void setWerkUren(ArrayList<WerkUren> werkUren) {
        this.werkUren = werkUren;
    }

    public int getRamingUren() {
        return ramingUren;
    }

    public void setRamingUren(int ramingUren) {
        this.ramingUren = ramingUren;
    }

    public boolean isOpdrachtAfgewerkt() {
        return opdrachtAfgewerkt;
    }

    public void setOpdrachtAfgewerkt(boolean opdrachtAfgewerkt) {
        this.opdrachtAfgewerkt = opdrachtAfgewerkt;
    }

    public boolean isTussentijdseFacturatieMogelijk() {
        return tussentijdseFacturatieMogelijk;
    }

    public void setTussentijdseFacturatieMogelijk(boolean tussentijdseFacturatieMogelijk) {
        this.tussentijdseFacturatieMogelijk = tussentijdseFacturatieMogelijk;
    }

    public boolean isVerderInTePlannen() {
        return verderInTePlannen;
    }

    public void setVerderInTePlannen(boolean verderInTePlannen) {
        this.verderInTePlannen = verderInTePlannen;
    }

    public LocalDateTime getDetailAanmaakDatum() {
        return detailAanmaakDatum;
    }

    public void setDetailAanmaakDatum(LocalDateTime detailAanmaakDatum) {
        this.detailAanmaakDatum = detailAanmaakDatum;
    }
}
