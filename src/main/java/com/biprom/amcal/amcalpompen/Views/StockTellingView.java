package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.StockTellingDesign;
import com.biprom.amcal.amcalpompen.Entities.Artikel;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.biprom.amcal.amcalpompen.repositories.StockRepository;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.biprom.amcal.amcalpompen.Views.MainView.VIEW_NAME;

@SpringComponent
@UIScope
@SpringView(name = VIEW_NAME)


public class StockTellingView extends StockTellingDesign implements View {
    public static final String VIEW_NAME = "stocktelling";
    StockRepository stockRepository;
    Artikel artikel = new Artikel();
    List<String>fillListArtikelTypeGegevens = new ArrayList<>(  );
    List<String>fillListPompTypeGegevens = new ArrayList<>(  );
    List<String>fillListAsAfdichtingen = new ArrayList<>(  );
    List<String>fillListKitSlijtDelen = new ArrayList<>(  );
    List<String>fillListPompKapVoet = new ArrayList<>(  );
    List<String>fillListOring = new ArrayList<>(  );
    List<String>fillListWaaiersKamers = new ArrayList<>(  );
    List<String>fillListMantelTrekstang = new ArrayList<>(  );
    List<String>fillListAllerlei = new ArrayList<>(  );
    @Autowired
    public StockTellingView(StockRepository stockRepository) {

        this.stockRepository = stockRepository;

        bSave.addClickListener( e -> {



            leesHoofdGegevens();
            leesArtikelTypeGegevens();
            leesPompTypeGegevens();
            leesAsAfdichtingen();
            leesKitSlijtdelen();
            leesPompkapVoet();
            leesKitORingen();
            leesWaaiersKamers();
            leesMantelTrekstang();
            leesAllerlei();

            //artikel.setId( LocalDateTime.now() );

            stockRepository.save( artikel );

            clearAllFields();

            fillListArtikelTypeGegevens.clear();
            fillListPompTypeGegevens.clear();
            fillListAsAfdichtingen.clear() ;
            fillListKitSlijtDelen.clear();
            fillListPompKapVoet.clear() ;
            fillListOring.clear() ;
            fillListWaaiersKamers.clear();
            fillListMantelTrekstang.clear();
            fillListAllerlei.clear();

            tfStockAantal.setValue( "0" );
            tfAantalInBulk.setValue( "0" );

        } );

    }

    public void leesHoofdGegevens(){


        artikel.setArtikelCode( tfArtikelCode.getValue() );
        artikel.setStockAantal( Integer.parseInt( tfStockAantal.getValue() ) );
        artikel.setCommentaarToevoeging( tfCommentaarToevoeging.getValue() );
        artikel.setAantalInBulk( Integer.parseInt(  tfAantalInBulk.getValue()) );
        artikel.setBulkNummer( tfBulkNummer.getValue() );
    }

    public void leesArtikelTypeGegevens(){


       if(checkbPompOnderdeel.getValue() == true){

           fillListArtikelTypeGegevens.add( "pomponderdeel" );
       }

        if(checkbCompletePomp.getValue() == true){

            fillListArtikelTypeGegevens.add( "complete pomp" );
        }

        if(checkbElekrischMateriaal.getValue() == true){

            fillListArtikelTypeGegevens.add( "elektrisch materiaal" );
        }

        if(checkbMotorLager.getValue() == true){

            fillListArtikelTypeGegevens.add( "motorlager" );
        }

        if(checkbCompleteMotor.getValue() == true){

            fillListArtikelTypeGegevens.add( "complete motor" );
        }

        if(checkbMechanischMateriaal.getValue() == true){

            fillListArtikelTypeGegevens.add( "mechanisch materiaal" );
        }

        artikel.setArtikelType( fillListArtikelTypeGegevens );


    }

    public void leesPompTypeGegevens(){

        if(checkbCRN1.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)1" );
        }

        if(checkbCRN3.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)3" );
        }

        if(checkbCRN5.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)5" );
        }

        if(checkbCRN10.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)10" );
        }

        if(checkbCRN15.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)15" );
        }

        if(checkbCRN20.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)20" );
        }

        if(checkbCRN32.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)32" );
        }

        if(checkbCRN45.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)45" );
        }

        if(checkbCRN90.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)90" );
        }

        if(checkbCRN120.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)120" );
        }

        if(checkbCRN150.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)150" );
        }

        if(checkbCRN2.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)2" );
        }

        if(checkbCRN4.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)4" );
        }

        if(checkbCRN8.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)8" );
        }

        if(checkbCRN16.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)16" );
        }

        if(checkbCRN30.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)30" );
        }

        if(checkbCRN60.getValue() == true){

            fillListPompTypeGegevens.add( "CR(N)60" );
        }

        if(tfAnderPompType != null){

            fillListPompTypeGegevens.add(tfAnderPompType.getValue());

        }

        artikel.setPompType( fillListPompTypeGegevens  );


    }


    public void leesAsAfdichtingen(){

        if(checkbDia12.getValue() == true){

            fillListAsAfdichtingen.add("diameter 12");

        }

        if(checkbDia16.getValue() == true){

            fillListAsAfdichtingen.add("diameter 16");

        }

        if(checkbDia28.getValue() == true){

            fillListAsAfdichtingen.add("diameter 28");

        }

        if(checkbDia38.getValue() == true){

            fillListAsAfdichtingen.add("diameter 38");

        }

        if(checkbDia48.getValue() == true){

            fillListAsAfdichtingen.add("diameter 48");

        }

        if(checkbHQQ.getValue() == true){

            fillListAsAfdichtingen.add("HQQ");

        }

        if(checkbAUU.getValue() == true){

            fillListAsAfdichtingen.add("AUU");

        }

        if(checkbRUU.getValue() == true){

            fillListAsAfdichtingen.add("diameter RUU");

        }

        if(checkbBUB.getValue() == true){

            fillListAsAfdichtingen.add("BUB");

        }

        if(checkbBAQ.getValue() == true){

            fillListAsAfdichtingen.add("BAQ");

        }

        if(checkbBQQ.getValue() == true){

            fillListAsAfdichtingen.add("BQQ");

        }

        if(checkbGQQ.getValue() == true){

            fillListAsAfdichtingen.add("GQQ");

        }

        if(checkbEPDM.getValue() == true){

            fillListAsAfdichtingen.add("EPDM");

        }

        if(checkbVITON.getValue() == true){

            fillListAsAfdichtingen.add("VITON");

        }

        artikel.setAsAfdichting( fillListAsAfdichtingen );

    }


    public void leesKitSlijtdelen(){

        if(checkbNeckWit.getValue() == true){

            fillListKitSlijtDelen.add("Neck wit (kamer)");

        }

        if(checkbLagertje.getValue() == true){

            fillListKitSlijtDelen.add("lagertje");

        }

        if(checkbNeckRingWaaier.getValue() == true){

            fillListKitSlijtDelen.add("neck ring waaier");

        }

        if(checkbNeckRingHouder.getValue() == true){

            fillListKitSlijtDelen.add("neckringhouder (kamer)");

        }

        if(checkbBodemLager.getValue() == true){

            fillListKitSlijtDelen.add("bodemlager (model A)");

        }

        artikel.setKitSlijtdelen( fillListKitSlijtDelen );

    }

    public void leesPompkapVoet(){

        if(checkbPompkapGietijzer.getValue() == true){

            fillListPompKapVoet.add("pompkap gietijzer");

        }

        if(checkbPompkapInox.getValue() == true){

            fillListPompKapVoet.add("pompkap inox");

        }

        if(checkbVoetplaat.getValue() == true){

            fillListPompKapVoet.add("voetplaat");

        }

        if(checkbVoetstuk.getValue() == true){

            fillListPompKapVoet.add("voetstuk");

        }

        artikel.setPompKapVoet( fillListPompKapVoet );


    }

    public void leesKitORingen(){

        if(checkbORing.getValue() == true){

            fillListOring.add("O-ring");

        }

        if(checkbVeertjes.getValue() == true){

            fillListOring.add("veertjes");

        }

        artikel.setKitORingen( fillListOring );


    }

    public void leesWaaiersKamers(){

        if(checkbWaaier.getValue() == true){

            fillListWaaiersKamers.add("waaier");

        }

        if(checkbAfgedraaideWaaier.getValue() == true){

            fillListWaaiersKamers.add("afgedraaide waaier");

        }

        if(checkbTopKamer.getValue() == true){

            fillListWaaiersKamers.add("topkamer");

        }

        if(checkbKamer.getValue() == true){

            fillListWaaiersKamers.add("kamer");

        }

        artikel.setKitWaaiersKamer( fillListWaaiersKamers );


    }

    public void leesMantelTrekstang(){

        if(checkbTrekstang.getValue() == true){

            fillListMantelTrekstang.add("trekstang");

        }

        if(checkbTreklat.getValue() == true){

            fillListMantelTrekstang.add("treklat");

        }

        if(checkbPompas.getValue() == true){

            fillListMantelTrekstang.add("pompas");

        }

        if(checkbMantel.getValue() == true){

            fillListMantelTrekstang.add("mantel");

        }

        artikel.setMantelTrekstangTreklatPompas(  fillListMantelTrekstang);

    }

    public void leesAllerlei(){

        if(checkbAfdekplaatjes.getValue() == true){

            fillListAllerlei.add("afdekplaatjes");

        }

        if(checkbFlensDichtingen.getValue() == true){

            fillListAllerlei.add("flensdichtingen");

        }

        if(checkbFlens.getValue() == true){

            fillListAllerlei.add("flens");

        }

        artikel.setAllerlei( fillListAllerlei );

    }

    public void clearAllFields(){

        tfArtikelCode.clear();
        tfStockAantal.clear();
        tfCommentaarToevoeging.clear();
        tfBulkNummer.clear();
        tfAantalInBulk.clear();
        checkbPompOnderdeel.clear();
         checkbMotorLager.clear();
        checkbCompletePomp.clear();
         checkbCompleteMotor.clear();
         checkbElekrischMateriaal.clear();
         checkbMechanischMateriaal.clear();
         checkbCRN1.clear();
         checkbCRN3.clear();
        checkbCRN5.clear();
         checkbCRN10.clear();
        checkbCRN15.clear();
        checkbCRN20.clear();
        checkbCRN32.clear();
        checkbCRN45.clear();
         checkbCRN90.clear();
         checkbCRN120.clear();
        checkbCRN150.clear();
         checkbCRN2.clear();
         checkbCRN4.clear();
         checkbCRN8.clear();
        checkbCRN16.clear();
        checkbCRN30.clear();
        checkbCRN60.clear();
        tfAnderPompType.clear();
        checkbDia12.clear();
         checkbDia16.clear();
         checkbDia28.clear();
         checkbDia38.clear();
         checkbDia48.clear();
        checkbHQQ.clear();
         checkbAUU.clear();
         checkbRUU.clear();
         checkbBUB.clear();
         checkbBAQ.clear();
        checkbBQQ.clear();
         checkbGQQ.clear();
        checkbEPDM.clear();
        checkbVITON.clear();
        checkbNeckWit.clear();
       checkbLagertje.clear();
        checkbNeckRingWaaier.clear();
         checkbNeckRingHouder.clear();
         checkbBodemLager.clear();
        checkbPompkapGietijzer.clear();
         checkbPompkapInox.clear();
         checkbVoetplaat.clear();
         checkbVoetstuk.clear();
         checkbORing.clear();
        checkbVeertjes.clear();
        checkbWaaier.clear();
        checkbAfgedraaideWaaier.clear();
        checkbTopKamer.clear();
        checkbKamer.clear();
         checkbKamerMetLager.clear();
         checkbOndersteKamer.clear();
         checkbTrekstang.clear();
        checkbTreklat.clear();
         checkbPompas.clear();
        checkbMantel.clear();
         checkbAfdekplaatjes.clear();
        checkbFlensDichtingen.clear();
        checkbFlens.clear();

    }

}
