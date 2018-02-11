package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.biprom.amcal.amcalpompen.Entities.MainTicket;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.biprom.amcal.amcalpompen.Views.TicketView.VIEW_NAME;


@Component
@SpringView(name = VIEW_NAME)
public class TicketView extends TicketDesign implements View {

    public static final String VIEW_NAME = "UitwerkingTicket";


    public NieuwTicketView nieuwTicketView;
    public DetailGegevensTicketView detailGegevensTicketView;


    @Autowired
    public TicketView(NieuwTicketView nieuwTicketView, DetailGegevensTicketView detailGegevensTicketView) {
        this.nieuwTicketView = nieuwTicketView;
        this.detailGegevensTicketView = detailGegevensTicketView;


    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        ticketTabSheet.addTab( nieuwTicketView, "BASISGEGEVENS TICKET");
        ticketTabSheet.addTab( detailGegevensTicketView, "DETAILGEGEVENS TICKET");
    }

    public void setTicketItems(MainTicket mainTicket){
        nieuwTicketView.fillItemsFromSearch(mainTicket);
    }
}
