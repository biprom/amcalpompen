package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TechniekerInterventieDesign;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.TechniekerInterventieView.VIEW_NAME;

@Component
@SpringView(name = VIEW_NAME)
@UIScope

public class TechniekerInterventieView extends TechniekerInterventieDesign implements View {

    public static final String VIEW_NAME = "TechniekerInterventie";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
