package com.biprom.amcal.amcalpompen;


import com.biprom.amcal.amcalpompen.Entities.MainTicket;
import com.biprom.amcal.amcalpompen.Views.MainView;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;


@SpringUI
@ComponentScan("com.biprom.amcal.amcalpompen")
@VaadinServletConfiguration(ui = MainUI.class, productionMode = false, widgetset = "com.biprom.amcal.amcalpompen.WidgettestWidgetset")
@Widgetset("com.biprom.amcal.amcalpompen.WidgettestWidgetset")

public class MainUI extends UI {

    @Autowired
    SpringViewProvider viewProvider;


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(viewProvider);
        navigator.navigateTo(MainView.VIEW_NAME);



    }
}

