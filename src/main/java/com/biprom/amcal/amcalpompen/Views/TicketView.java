package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.biprom.amcal.amcalpompen.Entities.MainTicket;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TabSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import static com.biprom.amcal.amcalpompen.Views.TicketView.VIEW_NAME;


@SpringComponent
@UIScope
@SpringView(name = VIEW_NAME)


public class TicketView extends TicketDesign implements View {

    public static final String VIEW_NAME = "UitwerkingTicket";


    public NieuwTicketView nieuwTicketView;
    public DetailGegevensTicketView detailGegevensTicketView;


    @Autowired
    public TicketView(NieuwTicketView nieuwTicketView) {
        this.nieuwTicketView = nieuwTicketView;

        ticketTabSheet.addTab( nieuwTicketView, "BASISGEGEVENS TICKET");

        bNieuwDetail.addClickListener( e ->  {
            ticketTabSheet.addTab(  new DetailGegevensTicketView(), "DETAIL - " + LocalDateTime.now() );
        });

        bVerwijderDetail.addClickListener( e -> {
            detailGegevensTicketView = (DetailGegevensTicketView) ticketTabSheet.getSelectedTab();
            nieuwTicketView.removeDetailTicket( detailGegevensTicketView.saveDetailTicket() );
            nieuwTicketView.saveSameTicket();
            ticketTabSheet.removeComponent( ticketTabSheet.getSelectedTab() );
        } );

        bBewaarDeetail.addClickListener( e -> {
            detailGegevensTicketView = (DetailGegevensTicketView) ticketTabSheet.getSelectedTab();
            nieuwTicketView.setDetailTicket( detailGegevensTicketView.saveDetailTicket() );
            nieuwTicketView.saveSameTicket();

        });


    }




    public void setMainTicketItems(MainTicket mainTicket){

        ticketTabSheet.removeAllComponents();
        ticketTabSheet.addTab( nieuwTicketView, "BASISGEGEVENS TICKET");
        nieuwTicketView.fillMainTicketItemsFromSearch(mainTicket);

        Iterator<DetailTicket>detailTicketIterator = mainTicket.getDetails().iterator();
        while (detailTicketIterator.hasNext()){
            DetailGegevensTicketView dgtv = new DetailGegevensTicketView();
            DetailTicket detailTicket = detailTicketIterator.next();
            dgtv.setDetailTicketViewWithData(  detailTicket );
            ticketTabSheet.addTab( dgtv , "DETAIL - "+ detailTicket.getDetailAanmaakDatum());

        }


    }





}
