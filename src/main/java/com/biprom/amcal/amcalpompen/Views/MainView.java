package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.MainDesign;
import com.biprom.amcal.amcalpompen.Design.StockTellingDesign;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

import static com.biprom.amcal.amcalpompen.Views.MainView.VIEW_NAME;


@SpringComponent
@UIScope
@SpringView(name = VIEW_NAME)

public class MainView extends MainDesign implements View {

    @Autowired
    SpringViewProvider viewProvider;
    NieuwTicketView nieuwTicketView;

    public static final String VIEW_NAME = "mainview";

    @Autowired
    public MainView(NieuwTicketView nieuwTicketView) {
        this.nieuwTicketView = nieuwTicketView;


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Navigator subNavigator = new Navigator(UI.getCurrent(), subPanel);
        subNavigator.addProvider(viewProvider);
        subNavigator.navigateTo(ZoekTicketView.VIEW_NAME);

        zoekButton.addClickListener(clickEvent -> subNavigator.navigateTo(ZoekTicketView.VIEW_NAME));
        uitwerkingButton.addClickListener(clickEvent -> subNavigator.navigateTo(TicketView.VIEW_NAME));
        invoegButton.addClickListener(clickEvent -> subNavigator.navigateTo(IngevenGegevensView.VIEW_NAME));
        nieuwButton.addClickListener(clickEvent -> {
            nieuwTicketView.clearDataFromTicketView();
            subNavigator.navigateTo(NieuwTicketView.VIEW_NAME);

        });
        stockButton.addClickListener( clickEvent -> subNavigator.navigateTo( StockTellingView.VIEW_NAME ) );



    }
}
