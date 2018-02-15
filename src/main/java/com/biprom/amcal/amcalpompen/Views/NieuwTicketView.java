package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.nieuwTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.*;
import com.biprom.amcal.amcalpompen.repositories.CustomerRepository;
import com.biprom.amcal.amcalpompen.repositories.MainTicketRepository;
import com.vaadin.data.HasValue;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import org.springframework.beans.factory.annotation.Autowired;


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

    @Autowired
    public NieuwTicketView(CustomerRepository customerRepository, MainTicketRepository mainTicketRepository) {
        this.customerRepository = customerRepository;
        this.mainTicketRepository = mainTicketRepository;

        List<Klanten>klantenLijst = customerRepository.findAll();
        cbOpdrachtgever.setItems(klantenLijst);
        cbOpdrachtgever.setItemCaptionGenerator( p  -> p.getBedrijfsNaam());

        cbEindklant.setItems(klantenLijst);
        cbEindklant.setItemCaptionGenerator(p -> p.getBedrijfsNaam());

        cbOpdrachtgever.addValueChangeListener(comboEvent ->  fillAanvragerCombobox(cbOpdrachtgever.getValue()));
        cbOpdrachtgever.addValueChangeListener(comboEvent -> fillAanvragerFacturatieAdresComboBox(cbOpdrachtgever.getValue()));

        cbEindklant.addValueChangeListener(comboEvent ->  fillEindklantCombobox(cbEindklant.getValue()));
        cbEindklant.addValueChangeListener(comboEvent -> fillEindklantFacturatieAdresComboBox(cbEindklant.getValue()));

        cbPrioriteitTicket.setItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        dpDatumTicket.setValue(LocalDate.now());

        bSlaTicketOp.addClickListener(e -> saveTicket());


    }





    private void saveTicket() {
        MainTicket nieuwTicket = new MainTicket();
        nieuwTicket.setIngegevenLeverAdres( cbEindklantLeverAdres.getValue() );
        nieuwTicket.setAanvraagDatumTicket(dpDatumTicket.getValue());
        nieuwTicket.setContactPersoonEindklant(cbEindklantContactPersoon.getValue());
        nieuwTicket.setContactPersoonKlant(cbContactPersoon.getValue());
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

        //TODO
        //autogenerate AM- number



        mainTicketRepository.save(nieuwTicket);
    }

    private void fillEindklantCombobox(Klanten geselecteerdeKlant) {
        List<Personen>personen = geselecteerdeKlant.getAanvragers();
        cbEindklantContactPersoon.setItems(personen);
        cbEindklantContactPersoon.setItemCaptionGenerator(p -> p.getVoorNaam() + " " + p.getNaam());
        cbEindklantContactPersoon.addValueChangeListener(comboEvent -> fillEindklantTelefoonTextField(cbEindklantContactPersoon.getValue()));
    }

    private void fillEindklantTelefoonTextField(Personen geselecteerdePersoon) {
        tfEindklantGsmNummer.setValue(geselecteerdePersoon.getGsmNummer());


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
        tfGsmNummer.setValue(geselecteerdePersoon.getGsmNummer());


    }

    private void fillAanvragerFacturatieAdresComboBox(Klanten geselecteerdeKlant) {
        Adres facturatieAdres = geselecteerdeKlant.getFacturatieAdres();
        cbFacturatieAdres.setItems(facturatieAdres);
        cbFacturatieAdres.setItemCaptionGenerator(p -> p.getPostcode() + " " + p.getStad() + " " + p.getStraat() + " " + p.getNummer());

    }

    public void fillMainTicketItemsFromSearch(MainTicket mainTicket){


        //fill all fields for MainTicket
        dpDatumTicket.setValue(mainTicket.getAanvraagDatumTicket());
        cbEindklantContactPersoon.setValue(mainTicket.getContactPersoonEindklant());
        cbContactPersoon.setValue(mainTicket.getContactPersoonKlant());
        cbEindklant.setValue(mainTicket.getEindKlant());

        tfInterneOmperkingen.setValue(mainTicket.getInterneOpmerkingen());

        cbOpdrachtgever.setValue(mainTicket.getOpdrachtgever());
        cbPrioriteitTicket.setValue(mainTicket.getPrioriteitTicket());
        tfEindklantReferentie.setValue(mainTicket.getReferentieEindklant());
        tfReferentieOpdrachtgever.setValue(mainTicket.getReferentieOpdrachtgever());
        tfProbleemOmschrijving.setValue(mainTicket.getVraagKlant());
        tfTicketnummer.setValue(mainTicket.getTicketNummer());
        cbFacturatieAdres.setValue( mainTicket.getOpdrachtgever().getFacturatieAdres() );
        cbEindklantLeverAdres.setValue( mainTicket.getIngegevenLeverAdres() );

        checkbInterventie.setValue( mainTicket.isInterventie() );
        checkbBestek.setValue( mainTicket.isHerstellingBestek() );
        checkbBestekGoedgekeurd.setValue( mainTicket.isHerstellingGoedgekeurd() );
        checkbUitvoering.setValue( mainTicket.isHerstellingUitvoer() );
        checkbofferte.setValue(mainTicket.isOfferte());
        checkbOfferteGoedgekeurd.setValue(mainTicket.isOfferteGoedgekeurd());


        }






}
