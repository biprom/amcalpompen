package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.DetailTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.biprom.amcal.amcalpompen.SubWindows.ProductSubWindow;
import com.vaadin.navigator.View;
import com.vaadin.ui.UI;

import java.time.LocalDateTime;


public class DetailGegevensTicketView extends DetailTicketDesign implements View {

	public static final String VIEW_NAME = "ticketDetail";

	DetailTicket detailTicket = new DetailTicket();

	ProductSubWindow productSubWindow;

	public DetailGegevensTicketView(ProductSubWindow productSubWindow) {
		this.productSubWindow = productSubWindow;

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DetailGegevensTicketConf.class );

		datefAanmaakDatum.setValue(LocalDateTime.now());

		bAddProduct.addClickListener(f -> {

//            productSubWindow = context.getBean( ProductSubWindow.class );
			UI.getCurrent().addWindow(productSubWindow);
			productSubWindow.setHeight("600px");
			productSubWindow.setWidth("1200px");
			productSubWindow.setModal(true);

		});
	}


	public DetailTicket saveDetailTicket() {


		detailTicket.setArtikelNummerInstallatie(tfArtikelNummer.getValue());
		detailTicket.setInstallatieJaar(Integer.parseInt(tfJaarInstallatie.getValue()));
		detailTicket.setInstallatieWeek(Integer.parseInt(tfWeekInstallatie.getValue()));
		detailTicket.setDetailAanmaakDatum(datefAanmaakDatum.getValue());
		detailTicket.setOmschrijvingInstallatie(taOmschrijvingInstallatie.getValue());

		detailTicket.setArtikelNummerPomp(tfArtikelNummerPomp.getValue());
		detailTicket.setJaarPomp(Integer.parseInt(tfJaarPomp.getValue()));
		detailTicket.setWeekPomp(Integer.parseInt(tfWeekPomp.getValue()));
		detailTicket.setOmschrijvingPomp(taOmschrijvingPomp.getValue());

		detailTicket.setVaststellingTechnieker(taVaststellingTechnieker.getValue());
		detailTicket.setInterneOpmerkingen(taInterneOpmerkingen.getValue());
		detailTicket.setRamingUren(Integer.parseInt(tfRamingUren.getValue()));

		detailTicket.setOpdrachtAfgewerkt(checkbOpdrachtAfgewerkt.getValue());
		detailTicket.setTussentijdseFacturatieMogelijk(checkbDeeltelijksFacturatie.getValue());
		detailTicket.setVerderInTePlannen(checkbVerderInTePlannen.getValue());

		return detailTicket;


	}

	public void setDetailTicketViewWithData(DetailTicket detailTicket) {

		tfArtikelNummer.setValue(detailTicket.getArtikelNummerInstallatie());
		tfJaarInstallatie.setValue(detailTicket.getInstallatieJaar().toString());
		tfWeekInstallatie.setValue(detailTicket.getInstallatieWeek().toString());
		datefAanmaakDatum.setValue(detailTicket.getDetailAanmaakDatum());
		taOmschrijvingInstallatie.setValue(detailTicket.getOmschrijvingInstallatie());

		tfArtikelNummerPomp.setValue(detailTicket.getArtikelNummerPomp());
		tfJaarPomp.setValue(detailTicket.getJaarPomp().toString());
		tfWeekPomp.setValue(detailTicket.getWeekPomp().toString());
		taOmschrijvingPomp.setValue(detailTicket.getOmschrijvingPomp());

		taVaststellingTechnieker.setValue(detailTicket.getVaststellingTechnieker());
		taInterneOpmerkingen.setValue(detailTicket.getInterneOpmerkingen());
		tfRamingUren.setValue("" + detailTicket.getRamingUren());

		checkbOpdrachtAfgewerkt.setValue(detailTicket.isOpdrachtAfgewerkt());
		checkbDeeltelijksFacturatie.setValue(detailTicket.isTussentijdseFacturatieMogelijk());
		checkbVerderInTePlannen.setValue(detailTicket.isVerderInTePlannen());


	}
}
