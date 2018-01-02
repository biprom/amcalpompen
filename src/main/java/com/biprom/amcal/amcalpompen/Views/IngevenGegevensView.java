package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.IngevenGegevensDesign;
import com.biprom.amcal.amcalpompen.Entities.Klanten;
import com.biprom.amcal.amcalpompen.repositories.CustomerRepository;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.IngevenGegevensView.VIEW_NAME;

@Component
@SpringView(name = VIEW_NAME)
@UIScope
public class IngevenGegevensView extends IngevenGegevensDesign implements View {

    public static final String VIEW_NAME = "ingevenGegevens";

    KlantenGegevensView klantenGegevensView;
    KlantenGegevensDetailView klantenGegevensDetailView;
    KlantenGegevensContactpersonenView klantenGegevensContactpersonenView;
    CustomerRepository customerRepository;



    @Autowired
    public IngevenGegevensView(KlantenGegevensView klantenGegevensView, KlantenGegevensDetailView klantenGegevensDetailView, KlantenGegevensContactpersonenView klantenGegevensContactpersonenView,CustomerRepository customerRepository) {
        this.klantenGegevensView = klantenGegevensView;
        this.klantenGegevensDetailView = klantenGegevensDetailView;
        this.klantenGegevensContactpersonenView = klantenGegevensContactpersonenView;
        this.customerRepository = customerRepository;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        invulTab.addTab(klantenGegevensView, "Hoofdgegevens Klant");
        invulTab.addTab(klantenGegevensDetailView, "Leveradressen Klant");
        invulTab.addTab(klantenGegevensContactpersonenView, "Contactpersonen");

        bZoekKlant.addClickListener(clickEvent -> fillSearchCustomer());

        listZoekKlant.addContextClickListener(contextClickEvent -> fillCustomerData());



    }

    private void fillCustomerData() {

        //TODO fill fields when customer is selected!!!

    }

    private void fillSearchCustomer() {

            listZoekKlant.setItems(customerRepository.findBybedrijfsNaamStartsWith(tfZoekKlant.getValue()));

    }


}
