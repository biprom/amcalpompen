package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TechniekerHerstelling;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import static com.biprom.amcal.amcalpompen.Views.TechniekerHerstellingView.VIEW_NAME;

@Component
@SpringView(name = VIEW_NAME)
@UIScope

public class TechniekerHerstellingView extends TechniekerHerstelling implements View{

    public static final String VIEW_NAME = "TechniekerHerstelling";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
