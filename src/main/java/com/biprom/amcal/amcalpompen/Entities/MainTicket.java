package com.biprom.amcal.amcalpompen.Entities;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@SpringComponent


public class MainTicket {

    @Id
    private String Id;

    private Klanten opdrachtgever;
    private Personen contactPersoonKlant;
    private String referentieOpdrachtgever;

    private Klanten eindKlant;
    private Personen contactPersoonEindklant;
    private String referentieEindklant;

    private Adres ingegevenLeverAdres;

    private int prioriteitTicket;
    private boolean interventie;
    private boolean herstellingBestek;
    private boolean herstellingGoedgekeurd;
    private boolean herstellingUitvoer;
    private boolean offerte;
    private boolean offerteGoedgekeurd;

    private String vraagKlant;
    private String interneOpmerkingen;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime aanvraagDatumTicket;

    private String ticketNummer;

    private ArrayList<DetailTicket> details = new ArrayList<DetailTicket>();



    public MainTicket() {
    }


    public Klanten getOpdrachtgever() {
        return opdrachtgever;
    }

    public void setOpdrachtgever(Klanten opdrachtgever) {
        this.opdrachtgever = opdrachtgever;
    }

    public Personen getContactPersoonKlant() {
        return contactPersoonKlant;
    }

    public void setContactPersoonKlant(Personen contactPersoonKlant) {
        this.contactPersoonKlant = contactPersoonKlant;
    }

    public String getReferentieOpdrachtgever() {
        return referentieOpdrachtgever;
    }

    public void setReferentieOpdrachtgever(String referentieOpdrachtgever) {
        this.referentieOpdrachtgever = referentieOpdrachtgever;
    }

    public Klanten getEindKlant() {
        return eindKlant;
    }

    public void setEindKlant(Klanten eindKlant) {
        this.eindKlant = eindKlant;
    }

    public Personen getContactPersoonEindklant() {
        return contactPersoonEindklant;
    }

    public void setContactPersoonEindklant(Personen contactPersoonEindklant) {
        this.contactPersoonEindklant = contactPersoonEindklant;
    }

    public String getReferentieEindklant() {
        return referentieEindklant;
    }

    public void setReferentieEindklant(String referentieEindklant) {
        this.referentieEindklant = referentieEindklant;
    }

    public int getPrioriteitTicket() {
        return prioriteitTicket;
    }

    public void setPrioriteitTicket(int prioriteitTicket) {
        this.prioriteitTicket = prioriteitTicket;
    }

    public boolean isInterventie() {
        return interventie;
    }

    public void setInterventie(boolean interventie) {
        this.interventie = interventie;
    }


    public boolean isHerstellingGoedgekeurd() {
        return herstellingGoedgekeurd;
    }

    public void setHerstellingGoedgekeurd(boolean herstellingGoedgekeurd) {
        this.herstellingGoedgekeurd = herstellingGoedgekeurd;
    }

    public boolean isHerstellingUitvoer() {
        return herstellingUitvoer;
    }

    public void setHerstellingUitvoer(boolean herstellingUitvoer) {
        this.herstellingUitvoer = herstellingUitvoer;
    }

    public boolean isHerstellingBestek() {
        return herstellingBestek;
    }

    public void setHerstellingBestek(boolean herstellingBestek) {
        this.herstellingBestek = herstellingBestek;
    }

    public boolean isOfferte() {
        return offerte;
    }

    public void setOfferte(boolean offerte) {
        this.offerte = offerte;
    }

    public boolean isOfferteGoedgekeurd() {
        return offerteGoedgekeurd;
    }

    public void setOfferteGoedgekeurd(boolean offerteGoedgekeurd) {
        this.offerteGoedgekeurd = offerteGoedgekeurd;
    }

    public String getVraagKlant() {
        return vraagKlant;
    }

    public void setVraagKlant(String vraagKlant) {
        this.vraagKlant = vraagKlant;
    }

    public String getInterneOpmerkingen() {
        return interneOpmerkingen;
    }

    public void setInterneOpmerkingen(String interneOpmerkingen) {
        this.interneOpmerkingen = interneOpmerkingen;
    }

    public LocalDateTime getAanvraagDatumTicket() {
        return aanvraagDatumTicket;
    }

    public void setAanvraagDatumTicket(LocalDateTime aanvraagDatumTicket) {
        this.aanvraagDatumTicket = aanvraagDatumTicket;
    }

    public String getTicketNummer() {
        return ticketNummer;
    }

    public void setTicketNummer(String ticketNummer) {
        this.ticketNummer = ticketNummer;
    }

    public ArrayList<DetailTicket> getDetails() {
        return details;
    }

    public void setDetail(DetailTicket detail) {
        details.add( detail );
    }

    public String getContactPersoonKlantNaam(){
        return contactPersoonKlant.getVoorNaam() + " " + contactPersoonKlant.getNaam();
    }

    public String getContactPersoonEindklantNaam(){
        return contactPersoonEindklant.getVoorNaam()+ " " + contactPersoonEindklant.getNaam();
    }

    public Adres getIngegevenLeverAdres() {
        return ingegevenLeverAdres;
    }

    public void setIngegevenLeverAdres(Adres ingegevenLeverAdres) {
        this.ingegevenLeverAdres = ingegevenLeverAdres;
    }
}
