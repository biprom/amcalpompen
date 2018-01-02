package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TicketHerstellingSubDesign;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.TicketHerstellingSubView.VIEW_NAME;

@Component
@SpringView(name = VIEW_NAME)
@UIScope

public class TicketHerstellingSubView extends TicketHerstellingSubDesign implements View {

    public static final String VIEW_NAME = "Herstelling";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
