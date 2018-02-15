package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.DetailTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.DetailGegevensTicketView.VIEW_NAME;

@SpringComponent
@UIScope
@SpringView(name = VIEW_NAME)

public class DetailGegevensTicketView extends DetailTicketDesign implements View {

    public static final String VIEW_NAME = "ticketDetail";


    public DetailGegevensTicketView() {
        DetailTicket detailTicket = new DetailTicket();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    public void saveDetailTicket(DetailTicket detailTicket){
        detailTicket.setArtikelNummerInstallatie( tfArtikelNummer.getValue() );
        detailTicket.setInstallatieJaar( Integer.parseInt( cbJaarInstallatie.getValue() ) );
        detailTicket.setInstallatieWeek( Integer.parseInt(cbWeekInstallatie.getValue()) );
        detailTicket.setDetailAanmaakDatum( datefAanmaakDatum.getValue() );
        detailTicket.setOmschrijvingInstallatie( taOmschrijvingInstallatie.getValue() );

        detailTicket.setArtikelNummerPomp( tfArtikelNummerPomp.getValue() );
        detailTicket.setJaarPomp( Integer.parseInt( cbJaarPomp.getValue() ) );
        detailTicket.setWeekPomp( Integer.parseInt( cbWeekPomp.getValue() ) );
        detailTicket.setOmschrijvingPomp( taOmschrijvingPomp.getValue() );

        detailTicket.setVaststellingTechnieker( taVaststellingTechnieker.getValue() );
        detailTicket.setInterneOpmerkingen( taInterneOpmerkingen.getValue() );
        detailTicket.setRamingUren( Integer.parseInt(tfRamingUren.getValue()) );

        detailTicket.setOpdrachtAfgewerkt( checkbOpdrachtAfgewerkt.getValue() );
        detailTicket.setTussentijdseFacturatieMogelijk( checkbDeeltelijksFacturatie.getValue() );
        detailTicket.setVerderInTePlannen( checkbVerderInTePlannen.getValue() );
    }
}
