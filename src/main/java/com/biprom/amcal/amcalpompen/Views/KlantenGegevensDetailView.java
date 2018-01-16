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
    Adres adr1 = new Adres();
    Adres adr2 = new Adres();
    Adres adr3 = new Adres();
    Adres adr4 = new Adres();

    public KlantenGegevensDetailView() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    public List<Adres>returnDiliveryAdresses(){

            //test lijntje commentaar

            adr1.setStraat(tfLeverStraat1.getValue());
            adr1.setStad(tfLeverStad1.getValue());
            adr1.setPostcode(tfLeverPostcode1.getValue());
            adr1.setNummer(tfLeverNummer1.getValue());
            adr1.setCommentaar(tfLeverCommentaar1.getValue());
            adr1.setBus(tfLeverBus1.getValue());
            adr1.setLand(tfLeverLand1.getValue());



            leverAdressen.add(0, adr1);

            adr2.setStraat(tfLeverStraat2.getValue());
            adr2.setStad(tfLeverStad2.getValue());
            adr2.setPostcode(tfLeverPostcode2.getValue());
            adr2.setNummer(tfLeverNummer2.getValue());
            adr2.setCommentaar(tfLeverCommentaar2.getValue());
            adr2.setBus(tfLeverBus2.getValue());
            adr2.setLand(tfLeverLand2.getValue());

            leverAdressen.add(1, adr2);

            adr3.setStraat(tfLeverStraat3.getValue());
            adr3.setStad(tfLeverStad3.getValue());
            adr3.setPostcode(tfLeverPostcode3.getValue());
            adr3.setNummer(tfLeverNummer3.getValue());
            adr3.setCommentaar(tfLeverCommentaar3.getValue());
            adr3.setBus(tfLeverBus3.getValue());
            adr3.setLand(tfLeverLand3.getValue());

            leverAdressen.add(2, adr3);

            adr4.setStraat(tfLeverStraat4.getValue());
            adr4.setStad(tfLeverStad4.getValue());
            adr4.setPostcode(tfLeverPostcode4.getValue());
            adr4.setNummer(tfLeverNummer4.getValue());
            adr4.setCommentaar(tfLeverCommentaar4.getValue());
            adr4.setBus(tfLeverBus4.getValue());
            adr4.setLand(tfLeverLand4.getValue());

            leverAdressen.add(3, adr4);

            System.out.println("adressenlijst die moet worden doorgegeven is = " + leverAdressen.toString());

        return leverAdressen;
    }


}
