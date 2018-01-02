package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.ZoekTicketDesign;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import static com.biprom.amcal.amcalpompen.Views.ZoekTicketView.VIEW_NAME;

@SpringComponent
@SpringView(name = VIEW_NAME)
@UIScope
public class ZoekTicketView extends ZoekTicketDesign implements View {

    public static final String VIEW_NAME = "zoekTicket";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
