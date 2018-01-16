package com.biprom.amcal.amcalpompen.Entities;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;

public class MainTicket {

    @Id
    private String Id;

    private Klanten opdrachtgever;
    private Personen contactPersoonKlant;
    private String referentieOpdrachtgever;

    private Klanten eindKlant;
    private Personen contactPersoonEindklant;
    private String referentieEindklant;

    private int prioriteitTicket;
    private boolean interventie;
    private boolean herstellingBestekUitvoer;
    private boolean offerte;
    private boolean offerteGoedgekeurd;

    private String vraagKlant;
    private String interneOpmerkingen;
    private Date  aanvraagDatumTicket;

    private String ticketNummer;

    private ArrayList<DetailTicket> details = new ArrayList<DetailTicket>();


}
