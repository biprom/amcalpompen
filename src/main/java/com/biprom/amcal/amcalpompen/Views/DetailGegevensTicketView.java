package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.DetailTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.DetailGegevensTicketView.VIEW_NAME;


public class DetailGegevensTicketView extends DetailTicketDesign implements View {

    public static final String VIEW_NAME = "ticketDetail";


    DetailTicket detailTicket = new DetailTicket();



    public DetailTicket saveDetailTicket(){


        detailTicket.setArtikelNummerInstallatie( tfArtikelNummer.getValue() );
        detailTicket.setInstallatieJaar( Integer.parseInt( tfJaarInstallatie.getValue() ) );
        detailTicket.setInstallatieWeek( Integer.parseInt(tfWeekInstallatie.getValue()) );
        detailTicket.setDetailAanmaakDatum( datefAanmaakDatum.getValue() );
        detailTicket.setOmschrijvingInstallatie( taOmschrijvingInstallatie.getValue() );

        detailTicket.setArtikelNummerPomp( tfArtikelNummerPomp.getValue() );
        detailTicket.setJaarPomp( Integer.parseInt( tfJaarPomp.getValue() ) );
        detailTicket.setWeekPomp( Integer.parseInt( tfWeekPomp.getValue() ) );
        detailTicket.setOmschrijvingPomp( taOmschrijvingPomp.getValue() );

        detailTicket.setVaststellingTechnieker( taVaststellingTechnieker.getValue() );
        detailTicket.setInterneOpmerkingen( taInterneOpmerkingen.getValue() );
        detailTicket.setRamingUren( Integer.parseInt(tfRamingUren.getValue()) );

        detailTicket.setOpdrachtAfgewerkt( checkbOpdrachtAfgewerkt.getValue() );
        detailTicket.setTussentijdseFacturatieMogelijk( checkbDeeltelijksFacturatie.getValue() );
        detailTicket.setVerderInTePlannen( checkbVerderInTePlannen.getValue() );

        return detailTicket;


    }
}
