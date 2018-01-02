package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.KlantenGegevevensDetailDesign;
import com.biprom.amcal.amcalpompen.Entities.Adres;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.biprom.amcal.amcalpompen.Views.KlantenGegevensDetailView.VIEW_NAME;


@Component
@SpringView(name = VIEW_NAME)
@UIScope
public class KlantenGegevensDetailView extends KlantenGegevevensDetailDesign implements View {

    public static final String VIEW_NAME = "KlantenGegevensDetail";

    List<Adres>leverAdressen = new ArrayList<Adres>();
    Adres adr = new Adres();

    public KlantenGegevensDetailView() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    public List<Adres>returnDiliveryAdresses(){


            adr.setStraat(tfLeverStraat1.getValue());
            adr.setStad(tfLeverStad1.getValue().toString());
            adr.setPostcode(tfLeverPostcode1.getValue().toString());
            adr.setNummer(tfLeverNummer1.getValue().toString());
            adr.setCommentaar(tfLeverCommentaar1.getValue().toString());
            adr.setBus(tfLeverBus1.getValue().toString());
            adr.setLand(tfLeverLand1.getValue().toString());

            leverAdressen.add(0, adr);

            adr.setStraat(tfLeverStraat2.getValue());
            adr.setStad(tfLeverStad2.getValue());
            adr.setPostcode(tfLeverPostcode2.getValue());
            adr.setNummer(tfLeverNummer2.getValue());
            adr.setCommentaar(tfLeverCommentaar2.getValue());
            adr.setBus(tfLeverBus2.getValue());
            adr.setLand(tfLeverLand2.getValue());

            leverAdressen.add(1, adr);

            adr.setStraat(tfLeverStraat3.getValue());
            adr.setStad(tfLeverStad3.getValue());
            adr.setPostcode(tfLeverPostcode3.getValue());
            adr.setNummer(tfLeverNummer3.getValue());
            adr.setCommentaar(tfLeverCommentaar3.getValue());
            adr.setBus(tfLeverBus3.getValue());
            adr.setLand(tfLeverLand3.getValue());

            leverAdressen.add(2, adr);

            adr.setStraat(tfLeverStraat4.getValue());
            adr.setStad(tfLeverStad4.getValue());
            adr.setPostcode(tfLeverPostcode4.getValue());
            adr.setNummer(tfLeverNummer4.getValue());
            adr.setCommentaar(tfLeverCommentaar4.getValue());
            adr.setBus(tfLeverBus4.getValue());
            adr.setLand(tfLeverLand4.getValue());

            leverAdressen.add(3, adr);

            System.out.println("adressenlijst die moet worden doorgegeven is = " + leverAdressen.toString());

        return leverAdressen;
    }


}
