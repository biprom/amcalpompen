package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TicketLeveringSubDesign;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.TicketLeveringSubView.VIEW_NAME;

@Component
@SpringView(name = VIEW_NAME)
@UIScope

public class TicketLeveringSubView extends TicketLeveringSubDesign implements View {

    public static final String VIEW_NAME = "TicketLevering";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
