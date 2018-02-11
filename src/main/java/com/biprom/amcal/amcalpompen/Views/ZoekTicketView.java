package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TicketDesign;
import com.biprom.amcal.amcalpompen.Design.ZoekTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.Klanten;
import com.biprom.amcal.amcalpompen.Entities.MainTicket;
import com.biprom.amcal.amcalpompen.Entities.Personen;
import com.biprom.amcal.amcalpompen.repositories.MainTicketRepository;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import com.vaadin.ui.components.grid.SingleSelectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import sun.applet.Main;
import sun.security.krb5.internal.Ticket;

import javax.management.Notification;

import java.util.List;
import java.util.Set;

import static com.biprom.amcal.amcalpompen.Views.ZoekTicketView.VIEW_NAME;

@SpringComponent
@SpringView(name = VIEW_NAME)
@UIScope
public class ZoekTicketView extends ZoekTicketDesign implements View {

    public static final String VIEW_NAME = "zoekTicket";

    MainTicketRepository mainTicketRepository;
    TicketView ticketView;

    @Autowired
    public ZoekTicketView(MainTicketRepository mainTicketRepository, TicketView ticketView) {
        this.mainTicketRepository = mainTicketRepository;
        this.ticketView = ticketView;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Navigator subNavigator = UI.getCurrent().getNavigator();


        tblTickets.setItems(mainTicketRepository.findAll());


        tblTickets.addColumn(MainTicket::getTicketNummer).setCaption("Ticket nummer");
        tblTickets.addColumn(MainTicket::getContactPersoonKlantNaam).setCaption("Opdrachtgever");
        tblTickets.addColumn(MainTicket::getContactPersoonEindklantNaam).setCaption("Eindklant");
        tblTickets.addColumn(MainTicket::getAanvraagDatumTicket).setCaption("Ticket Datum");
        tblTickets.addColumn(MainTicket::getVraagKlant).setCaption("Opdracht");

        tblTickets.addSelectionListener(selectionEvent -> { subNavigator.navigateTo(TicketView.VIEW_NAME);
                                                            ticketView.setTicketItems(selectionEvent.getFirstSelectedItem().get());




        });



    }
}
