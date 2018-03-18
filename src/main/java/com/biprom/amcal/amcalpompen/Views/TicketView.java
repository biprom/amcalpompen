package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.TicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.biprom.amcal.amcalpompen.Entities.MainTicket;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Iterator;

import static com.biprom.amcal.amcalpompen.Views.TicketView.VIEW_NAME;


@SpringComponent
@UIScope
@SpringView(name = VIEW_NAME)


public class TicketView extends TicketDesign implements View {

	public static final String VIEW_NAME = "UitwerkingTicket";


	NieuwTicketView nieuwTicketView;

	ApplicationContext context;

	@Autowired
	public TicketView(NieuwTicketView nieuwTicketView, ApplicationContext context) {
		this.nieuwTicketView = nieuwTicketView;
        this.context = context;

		ticketTabSheet.addTab(nieuwTicketView, "BASISGEGEVENS TICKET");

		bNieuwDetail.addClickListener(e -> {
			final DetailGegevensTicketView dgtv = context.getBean(DetailGegevensTicketView.class);
			ticketTabSheet.addTab(dgtv, "DETAIL - " + LocalDateTime.now());
		});

		bVerwijderDetail.addClickListener(e -> {
			DetailGegevensTicketView detailGegevensTicketView = (DetailGegevensTicketView) ticketTabSheet.getSelectedTab();
			nieuwTicketView.removeDetailTicket(detailGegevensTicketView.saveDetailTicket());
			nieuwTicketView.saveSameTicket();
			ticketTabSheet.removeComponent(ticketTabSheet.getSelectedTab());
		});

		bBewaarDeetail.addClickListener(e -> {
			DetailGegevensTicketView detailGegevensTicketView = (DetailGegevensTicketView) ticketTabSheet.getSelectedTab();
			nieuwTicketView.setDetailTicket(detailGegevensTicketView.saveDetailTicket());
			nieuwTicketView.saveSameTicket();

		});


	}


	public void setMainTicketItems(MainTicket mainTicket) {

		int i = 1;

		ticketTabSheet.removeAllComponents();
		ticketTabSheet.addTab(nieuwTicketView, "BASISGEGEVENS TICKET");
		nieuwTicketView.fillMainTicketItemsFromSearch(mainTicket);

		Iterator<DetailTicket> detailTicketIterator = mainTicket.getDetails().iterator();
		while (detailTicketIterator.hasNext()) {

			DetailTicket detailTicket = detailTicketIterator.next();
			DetailGegevensTicketView dgtv = context.getBean(DetailGegevensTicketView.class);
			dgtv.setDetailTicketViewWithData(detailTicket);
			ticketTabSheet.addTab(dgtv, "DETAIL - " +LocalDateTime.now());
		}


	}


}
