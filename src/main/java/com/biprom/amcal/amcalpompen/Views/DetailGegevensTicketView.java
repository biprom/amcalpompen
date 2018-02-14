package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.DetailTicketDesign;
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

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
