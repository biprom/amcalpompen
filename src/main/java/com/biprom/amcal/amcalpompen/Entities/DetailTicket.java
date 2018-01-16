package com.biprom.amcal.amcalpompen.Entities;

import org.springframework.data.annotation.Id;
import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.Date;

public class DetailTicket {

    @Id
    private String Id;

    private String artikelNummerInstallatie;
    private String omschrijvingInstallatie;
    private Date productieDatumInstallatie;

    private String artikelNummerPomp;
    private String omschrijvingPomp;
    private Date productieDatumPomp;

    private ArrayList<TicketBenodigdheden> benodigdheden = new ArrayList<TicketBenodigdheden>();

    private String vaststellingTechnieker;
    private String interneOpmerkingen;

    private ArrayList<WerkUren> werkUren = new ArrayList<WerkUren>();

    private int geraamdeUren;

    private boolean opdrachtAfgewerkt;
    private boolean tussentijdseFacturatieMogelijk;






}
