package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.nieuwTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.Klanten;
import com.biprom.amcal.amcalpompen.Entities.Personen;
import com.biprom.amcal.amcalpompen.repositories.CustomerRepository;
import com.vaadin.data.HasValue;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import static com.biprom.amcal.amcalpompen.Views.NieuwTicketView.VIEW_NAME;

@SpringComponent
@SpringView(name = VIEW_NAME)
@UIScope
public class NieuwTicketView extends nieuwTicketDesign implements View {

    public static final String VIEW_NAME = "nieuwTicket";

    CustomerRepository customerRepository;


    @Autowired
    public NieuwTicketView(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {


        cbOpdrachtgever.setItems(customerRepository.findAll());
        cbOpdrachtgever.setItemCaptionGenerator( p  -> p.getBedrijfsNaam());

        cbOpdrachtgever.addValueChangeListener(comboEvent ->  fillAanvragerCombobox(cbOpdrachtgever.getValue()));


    }

    public void fillAanvragerCombobox(Klanten geselecteerdeKlant)
    {

        List<Personen> personenArrayList = geselecteerdeKlant.getAanvragers();
        cbContactPersoon.setItems(personenArrayList);
        cbContactPersoon.setItemCaptionGenerator(p -> p.getVoorNaam() + " " + p.getNaam());


    }
}
