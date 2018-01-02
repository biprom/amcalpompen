package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TicketDesign;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.TicketView.VIEW_NAME;


@Component
@SpringView(name = VIEW_NAME)
public class TicketView extends TicketDesign implements View {

    public static final String VIEW_NAME = "UitwerkingTicket";

    public TicketLeveringSubView leveringSubView;
    public InterventieView interventieSubView;
    public TechniekerInterventieView techniekerInterventieView;
    public TicketHerstellingSubView ticketHerstellingSubView;
    public TechniekerHerstellingView techniekerHerstellingView;


    @Autowired
    public TicketView(TicketLeveringSubView leveringSubView, InterventieView interventieSubView, TechniekerInterventieView techniekerInterventieView, TicketHerstellingSubView ticketHerstellingSubView, TechniekerHerstellingView techniekerHerstellingView) {
        this.leveringSubView = leveringSubView;
        this.interventieSubView = interventieSubView;
        this.techniekerInterventieView = techniekerInterventieView;
        this.ticketHerstellingSubView = ticketHerstellingSubView;
        this.techniekerHerstellingView = techniekerHerstellingView;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        ticketTabSheet.addTab( leveringSubView, "LEVERING");
        ticketTabSheet.addTab( interventieSubView, "INTERVENTIE");
        ticketTabSheet.addTab( techniekerInterventieView, "INTERVENTIE (TECHNIEKER)");
        ticketTabSheet.addTab( ticketHerstellingSubView, "HERSTELLING ATELIER");
        ticketTabSheet.addTab( techniekerHerstellingView, "HERSTELLING ATELIER (TECHNIEKER)");
    }
}
