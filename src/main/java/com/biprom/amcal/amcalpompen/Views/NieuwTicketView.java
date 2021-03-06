package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.nieuwTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.*;
import com.biprom.amcal.amcalpompen.repositories.CustomerRepository;
import com.biprom.amcal.amcalpompen.repositories.MainTicketRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.vaadin.data.HasValue;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import sun.applet.Main;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


import static com.biprom.amcal.amcalpompen.Views.NieuwTicketView.VIEW_NAME;

@SpringComponent
@UIScope
@SpringView(name = VIEW_NAME)


public class NieuwTicketView extends nieuwTicketDesign implements View {

    public static final String VIEW_NAME = "nieuwTicket";

    CustomerRepository customerRepository;
    MainTicketRepository mainTicketRepository;

    List<Klanten>klantenLijst;

    MainTicket nieuwTicket;

    @Autowired
    public NieuwTicketView(CustomerRepository customerRepository, MainTicketRepository mainTicketRepository) {

        this.customerRepository = customerRepository;
        this.mainTicketRepository = mainTicketRepository;

        cbOpdrachtgever.setEmptySelectionAllowed( true );

        cbEindklant.setEmptySelectionAllowed( true );

        cbEindklantContactPersoon.setEmptySelectionAllowed( true );

        cbContactPersoon.setEmptySelectionAllowed( true );


        klantenLijst = customerRepository.findAll();
        cbOpdrachtgever.setItems(klantenLijst);
        cbOpdrachtgever.setItemCaptionGenerator( p  -> p.getBedrijfsNaam());

        cbEindklant.setItems(klantenLijst);
        cbEindklant.setItemCaptionGenerator(p -> p.getBedrijfsNaam());

        cbOpdrachtgever.addValueChangeListener(comboEvent ->  {
            if(cbOpdrachtgever.getValue() != null) {
                fillAanvragerCombobox( cbOpdrachtgever.getValue() );
                fillAanvragerFacturatieAdresComboBox( cbOpdrachtgever.getValue() );
            }
            else {
                cbContactPersoon.setSelectedItem( null );
                cbFacturatieAdres.setSelectedItem( null );
            }
        });


        cbEindklant.addValueChangeListener(comboEvent ->  {
            if(cbEindklant.getValue() != null) {
                fillEindklantCombobox( cbEindklant.getValue() );
                fillEindklantFacturatieAdresComboBox( cbEindklant.getValue() );
            }
            else {
                cbEindklantContactPersoon.setSelectedItem( null );
                cbEindklantLeverAdres.setSelectedItem( null );
            }
        });


        cbPrioriteitTicket.setItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        tfTicketnummer.setValue( LocalDateTime.now().toString() );

        dpDatumTicket.setValue(LocalDateTime.now());

        bSlaTicketOp.addClickListener(e -> {
            if(nieuwTicket == null) {
                saveNewTicket();
            }
            else {
                saveSameTicket();
            }
        });

    }





    public void saveNewTicket() {

        MainTicket nieuwTicket1 = new MainTicket();

        nieuwTicket1.setIngegevenLeverAdres( cbEindklantLeverAdres.getValue() );
        nieuwTicket1.setAanvraagDatumTicket(dpDatumTicket.getValue());
        nieuwTicket1.setContactPersoonEindklant(cbEindklantContactPersoon.getValue());
        nieuwTicket1.setContactPersoonKlant(cbContactPersoon.getValue());
        nieuwTicket1.setEindKlant(cbEindklant.getValue());
        nieuwTicket1.setInterneOpmerkingen(tfInterneOmperkingen.getValue());
        nieuwTicket1.setOpdrachtgever(cbOpdrachtgever.getValue());
        nieuwTicket1.setPrioriteitTicket(cbPrioriteitTicket.getValue());
        nieuwTicket1.setReferentieEindklant(tfEindklantReferentie.getValue());
        nieuwTicket1.setReferentieOpdrachtgever(tfReferentieOpdrachtgever.getValue());
        nieuwTicket1.setVraagKlant(tfProbleemOmschrijving.getValue());
        nieuwTicket1.setTicketNummer(tfTicketnummer.getValue());

        nieuwTicket1.setInterventie(checkbInterventie.getValue());
        nieuwTicket1.setHerstellingBestek( checkbBestek.getValue() );
        nieuwTicket1.setHerstellingGoedgekeurd(checkbBestekGoedgekeurd.getValue());
        nieuwTicket1.setHerstellingUitvoer(checkbUitvoering.getValue());
        nieuwTicket1.setOfferte(checkbofferte.getValue());
        nieuwTicket1.setOfferteGoedgekeurd(checkbOfferteGoedgekeurd.getValue());

        //TODO autogenerate TicketNumber!!!


        mainTicketRepository.save(nieuwTicket1);

    }

    public void saveSameTicket() {



        nieuwTicket.setIngegevenLeverAdres( cbEindklantLeverAdres.getValue() );
        nieuwTicket.setAanvraagDatumTicket(dpDatumTicket.getValue());
        nieuwTicket.setContactPersoonEindklant(cbEindklantContactPersoon.getValue());
        System.out.println( "contactpersooneindklant = "+  cbEindklantContactPersoon.getValue());
        nieuwTicket.setContactPersoonKlant(cbContactPersoon.getValue());
        System.out.println( "contactpersoonklant = "+  cbContactPersoon.getValue());
        nieuwTicket.setEindKlant(cbEindklant.getValue());
        nieuwTicket.setInterneOpmerkingen(tfInterneOmperkingen.getValue());
        nieuwTicket.setOpdrachtgever(cbOpdrachtgever.getValue());
        nieuwTicket.setPrioriteitTicket(cbPrioriteitTicket.getValue());
        nieuwTicket.setReferentieEindklant(tfEindklantReferentie.getValue());
        nieuwTicket.setReferentieOpdrachtgever(tfReferentieOpdrachtgever.getValue());
        nieuwTicket.setVraagKlant(tfProbleemOmschrijving.getValue());
        nieuwTicket.setTicketNummer(tfTicketnummer.getValue());

        nieuwTicket.setInterventie(checkbInterventie.getValue());
        nieuwTicket.setHerstellingBestek( checkbBestek.getValue() );
        nieuwTicket.setHerstellingGoedgekeurd(checkbBestekGoedgekeurd.getValue());
        nieuwTicket.setHerstellingUitvoer(checkbUitvoering.getValue());
        nieuwTicket.setOfferte(checkbofferte.getValue());
        nieuwTicket.setOfferteGoedgekeurd(checkbOfferteGoedgekeurd.getValue());

        //TODO autogenerate TicketNumber!!!


        mainTicketRepository.save(nieuwTicket);

    }

    private void fillEindklantCombobox(Klanten geselecteerdeKlant) {
        List<Personen>personen = geselecteerdeKlant.getAanvragers();
        cbEindklantContactPersoon.setItems(personen);
        cbEindklantContactPersoon.setItemCaptionGenerator(p -> p.getVoorNaam() + " " + p.getNaam());
        cbEindklantContactPersoon.addValueChangeListener(comboEvent -> {
            if(cbEindklantContactPersoon == null) {
                tfEindklantGsmNummer.setValue("");
            }
            else fillEindklantTelefoonTextField( cbEindklantContactPersoon.getValue() );
        });
    }

    private void fillEindklantTelefoonTextField(Personen geselecteerdePersoon) {
        if(geselecteerdePersoon != null) {
            tfEindklantGsmNummer.setValue( geselecteerdePersoon.getGsmNummer() );
        }
        else tfEindklantGsmNummer.setValue( "" );

    }

    private void fillEindklantFacturatieAdresComboBox(Klanten geselecteerdeKlant) {
        cbEindklantLeverAdres.setItems(geselecteerdeKlant.getLeverAdressen());
        cbEindklantLeverAdres.setItemCaptionGenerator(p -> p.getPostcode() + " " + p.getStad() + " " + p.getStraat() + " " + p.getNummer());
    }




    public void fillAanvragerCombobox(Klanten geselecteerdeKlant)
    {

        List<Personen> personenArrayList = geselecteerdeKlant.getAanvragers();
        cbContactPersoon.setItems(personenArrayList);
        cbContactPersoon.setItemCaptionGenerator(p -> p.getVoorNaam() + " " + p.getNaam());

        cbContactPersoon.addValueChangeListener(comboEvent -> fillAanvragerTelefoonTextField(cbContactPersoon.getValue()));

    }

    private void fillAanvragerTelefoonTextField(Personen geselecteerdePersoon) {

        if(geselecteerdePersoon != null) {
            tfGsmNummer.setValue( geselecteerdePersoon.getGsmNummer() );
        }
            else tfGsmNummer.setValue( "" );
    }

    private void fillAanvragerFacturatieAdresComboBox(Klanten geselecteerdeKlant) {
        Adres facturatieAdres = geselecteerdeKlant.getFacturatieAdres();
        cbFacturatieAdres.setItems(facturatieAdres);
        cbFacturatieAdres.setItemCaptionGenerator(p -> p.getPostcode() + " " + p.getStad() + " " + p.getStraat() + " " + p.getNummer());

    }

    public void fillMainTicketItemsFromSearch(MainTicket mainTicket){


        nieuwTicket = mainTicket;
        //fill all fields for MainTicket

        cbOpdrachtgever.setValue(nieuwTicket.getOpdrachtgever());
        cbEindklant.setValue(nieuwTicket.getEindKlant());
        dpDatumTicket.setValue(nieuwTicket.getAanvraagDatumTicket());
        cbEindklantContactPersoon.setValue(nieuwTicket.getContactPersoonEindklant());
        cbEindklantContactPersoon.setItemCaptionGenerator(p -> p.getVoorNaam() + " " + p.getNaam());
        fillEindklantTelefoonTextField(nieuwTicket.getContactPersoonEindklant());
        cbContactPersoon.setValue(nieuwTicket.getContactPersoonKlant());
        cbContactPersoon.setItemCaptionGenerator(p -> p.getVoorNaam() + " " + p.getNaam());
        fillAanvragerTelefoonTextField(nieuwTicket.getContactPersoonKlant());



        tfInterneOmperkingen.setValue(nieuwTicket.getInterneOpmerkingen());



        cbPrioriteitTicket.setValue(nieuwTicket.getPrioriteitTicket());
        tfEindklantReferentie.setValue(nieuwTicket.getReferentieEindklant());
        tfReferentieOpdrachtgever.setValue(nieuwTicket.getReferentieOpdrachtgever());
        tfProbleemOmschrijving.setValue(nieuwTicket.getVraagKlant());
        tfTicketnummer.setValue(nieuwTicket.getTicketNummer());
        cbFacturatieAdres.setValue( nieuwTicket.getOpdrachtgever().getFacturatieAdres() );
        cbEindklantLeverAdres.setValue( nieuwTicket.getIngegevenLeverAdres() );

        checkbInterventie.setValue( nieuwTicket.isInterventie() );
        checkbBestek.setValue( nieuwTicket.isHerstellingBestek() );
        checkbBestekGoedgekeurd.setValue( nieuwTicket.isHerstellingGoedgekeurd() );
        checkbUitvoering.setValue( nieuwTicket.isHerstellingUitvoer() );
        checkbofferte.setValue(nieuwTicket.isOfferte());
        checkbOfferteGoedgekeurd.setValue(nieuwTicket.isOfferteGoedgekeurd());


        }

        public void setDetailTicket(DetailTicket receivedDetailTicket) {

                ListIterator<DetailTicket>detailTicketIterator = nieuwTicket.getDetails().listIterator();
                Boolean i = false;

                //System.out.println( "receivedDetailTicket timestamp = "+ receivedDetailTicket.getDetailAanmaakDatum().toString() );

                while(detailTicketIterator.hasNext()){

                   // System.out.println( "iterated timestamps = "+ detailTicketIterator.next().getDetailAanmaakDatum().toString() );

                   if (receivedDetailTicket.getDetailAanmaakDatum().equals( detailTicketIterator.next().getDetailAanmaakDatum() ) == true){

                       detailTicketIterator.set( receivedDetailTicket );
                        i = true;
                    }

                }

                if( i == true) {
                    Notification.show( "detail is aangpast" );
                }

                else {
                    Notification.show( "nieuw detail is aangemaakt" );
                    nieuwTicket.setDetail( receivedDetailTicket );
                }


        }

    public void removeDetailTicket(DetailTicket receivedDetailTicket) {

        ListIterator<DetailTicket>detailTicketIterator = nieuwTicket.getDetails().listIterator();

        while(detailTicketIterator.hasNext()){


            if (receivedDetailTicket.getDetailAanmaakDatum().equals( detailTicketIterator.next().getDetailAanmaakDatum() ) == true){

               detailTicketIterator.remove();
            }

        }


    }

        public void clearDataFromTicketView(){

            //fill all fields for MainTicket
            dpDatumTicket.setValue(LocalDateTime.now());


            cbOpdrachtgever.setSelectedItem( null );
            cbEindklant.setSelectedItem( null );

            tfInterneOmperkingen.setValue("");
            cbPrioriteitTicket.setValue(1);
            tfEindklantReferentie.setValue("");
            tfReferentieOpdrachtgever.setValue("");
            tfProbleemOmschrijving.setValue("");
            tfTicketnummer.setValue("");
       ;

            checkbInterventie.setValue( false );
            checkbBestek.setValue( false );
            checkbBestekGoedgekeurd.setValue( false );
            checkbUitvoering.setValue( false );
            checkbofferte.setValue(false);
            checkbOfferteGoedgekeurd.setValue(false);


        }


}
