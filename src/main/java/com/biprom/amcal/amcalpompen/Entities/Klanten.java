package com.biprom.amcal.amcalpompen.Entities;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Klanten {


    @Id
    public String Id;

    public String bedrijfsNaam;
    public String afdeling;
    public List<Personen> aanvragers;
    public List<Adres> leverAdressen;
    public Adres facturatieAdres;

    public Klanten(String bedrijfsNaam, String afdeling, List<Personen> aanvragers, List<Adres> leverAdressen) {
        this.bedrijfsNaam = bedrijfsNaam;
        this.afdeling = afdeling;
        this.aanvragers = aanvragers;
        this.leverAdressen = leverAdressen;
    }

    public Klanten() {

    }

    public String getBedrijfsNaam() {
        return bedrijfsNaam;
    }

    public void setBedrijfsNaam(String bedrijfsNaam) {
        this.bedrijfsNaam = bedrijfsNaam;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public List<Personen> getAanvragers() {
        return aanvragers;
    }

    public void setAanvragers(List<Personen> aanvragers) {
        this.aanvragers = aanvragers;
    }

    public List<Adres> getLeverAdressen() {
        return leverAdressen;
    }

    public void setLeverAdressen(List<Adres> leverAdressen) {
        this.leverAdressen = leverAdressen;
    }

    public Adres getFacturatieAdres() {
        return facturatieAdres;
    }

    public void setFacturatieAdres(Adres facturatieAdres) {
        this.facturatieAdres = facturatieAdres;
    }

    @Override
    public String toString() {
        return "Klanten{" +
                "Id='" + Id + '\'' +
                ", bedrijfsNaam='" + bedrijfsNaam + '\'' +
                ", afdeling='" + afdeling + '\'' +
                ", aanvragers=" + aanvragers +
                ", leverAdressen=" + leverAdressen +
                ", facturatieAdres=" + facturatieAdres +
                '}';
    }


}
