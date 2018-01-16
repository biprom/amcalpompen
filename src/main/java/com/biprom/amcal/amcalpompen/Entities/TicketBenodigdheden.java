package com.biprom.amcal.amcalpompen.Entities;

import org.springframework.data.annotation.Id;

public class TicketBenodigdheden {

    @Id
    private String Id;

    private int aantal;
    private String artikelNummer;
    private String omschrijvingArtikel;
    private boolean gebruikt;
}
