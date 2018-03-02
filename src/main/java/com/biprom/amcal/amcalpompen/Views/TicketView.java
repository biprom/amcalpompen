package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Configuration.DetailGegevensTicketConf;
import com.biprom.amcal.amcalpompen.Design.TicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.biprom.amcal.amcalpompen.Entities.MainTicket;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.Iterator;

import static com.biprom.amcal.amcalpompen.Views.TicketView.VIEW_NAME;


@SpringComponent
@UIScope
@SpringView(name = VIEW_NAME)


public class TicketView extends TicketDesign implements View {

    public static final String VIEW_NAME = "UitwerkingTicket";


     NieuwTicketView nieuwTicketView;
     DetailGegevensTicketView detailGegevensTicketView;

     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DetailGegevensTicketConf.class );

    @Autowired
    public TicketView(NieuwTicketView nieuwTicketView) {
        this.nieuwTicketView = nieuwTicketView;
        this.detailGegevensTicketView = detailGegevensTicketView;



        ticketTabSheet.addTab( nieuwTicketView, "BASISGEGEVENS TICKET");

        bNieuwDetail.addClickListener( e ->  {
            ticketTabSheet.addTab(context.getBean( DetailGegevensTicketView.class ), "DETAIL - " + LocalDateTime.now() );
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
            DetailGegevensTicketView dgtv = context.getBean( DetailGegevensTicketView.class );
            DetailTicket detailTicket = detailTicketIterator.next();
            dgtv.setDetailTicketViewWithData(  detailTicket );
            ticketTabSheet.addTab( dgtv , "DETAIL - "+ detailTicket.getDetailAanmaakDatum());

        }


    }





}
