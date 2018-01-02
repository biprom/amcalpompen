package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.InterventieDesign;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.InterventieView.VIEW_NAME;

@Component
@SpringView(name = VIEW_NAME)
@UIScope
public class InterventieView extends InterventieDesign implements View {

    public static final String VIEW_NAME = "InterventieTicket";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
