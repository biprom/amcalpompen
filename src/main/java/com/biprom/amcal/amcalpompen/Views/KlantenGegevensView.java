package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.KlantenGegevensDesign;
import com.biprom.amcal.amcalpompen.Entities.Adres;
import com.biprom.amcal.amcalpompen.Entities.Klanten;
import com.biprom.amcal.amcalpompen.Entities.Personen;
import com.biprom.amcal.amcalpompen.repositories.CustomerRepository;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.biprom.amcal.amcalpompen.Views.IngevenGegevensView.VIEW_NAME;

@Component
@SpringView(name = VIEW_NAME)
@UIScope
public class KlantenGegevensView extends KlantenGegevensDesign implements View {

    public static final String VIEW_NAME = "KlantenGegevens";

    KlantenGegevensDetailView klantenGegevensDetailView;
    KlantenGegevensContactpersonenView klantenGegevensContactpersonenView;
    CustomerRepository customerRepository;
    

    Adres adres = new Adres();
    List<Adres> leverAdressen = new ArrayList<>();

    @Autowired
    public KlantenGegevensView(KlantenGegevensDetailView klantenGegevensDetailView, KlantenGegevensContactpersonenView klantenGegevensContactpersonenView, CustomerRepository customerRepository) {
        this.klantenGegevensDetailView = klantenGegevensDetailView;
        this.klantenGegevensContactpersonenView = klantenGegevensContactpersonenView;
        this.customerRepository = customerRepository;

        bKlantOpslaan.addClickListener(clickEvent -> slaKlantOpInDatbase());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    
    
    private void slaKlantOpInDatbase() {

        Klanten klant = new Klanten();


        klant.setBedrijfsNaam(tfBedrijfsNaam.getValue());
        klant.setAfdeling(tfAfdeling.getValue());
        klant.setFacturatieAdres(getFacAdres(adres));
        klant.setLeverAdressen(klantenGegevensDetailView.returnDiliveryAdresses());
        klant.setAanvragers(klantenGegevensContactpersonenView.returnCustomerContacts());


        //TODO check wether all parameters of klant is saved!!!

        customerRepository.save(klant);


    }



    private Adres getFacAdres(Adres adr) {
        adr.setLand(tfFacLand.getValue());
        adr.setBus(tfFacBus.getValue());
        adr.setCommentaar(tfFacCommentaar.getValue());
        adr.setNummer(tfFacNummer.getValue());
        adr.setPostcode(tfFacPostCode.getValue());
        adr.setStad(tfFacStad.getValue());
        adr.setStraat(tfFacStraat.getValue());
        return adr;
    }
}
