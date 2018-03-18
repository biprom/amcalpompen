package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.DetailTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.SubWindows.ProductSubWindow;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.hibernate.validator.constraints.Mod11Check;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;


public class DetailGegevensTicketView extends DetailTicketDesign implements View {

	public static final String VIEW_NAME = "ticketDetail";

	DetailTicket detailTicket = new DetailTicket();

	ProductSubWindow productSubWindow;
	ProductRepository productRepository;
	List<Product>artikelLijstOmschrijving;
	List<Product> productList = new ArrayList<>();


	@Autowired
	public DetailGegevensTicketView(ProductSubWindow productSubWindow, ProductRepository productRepository) {

		this.productSubWindow = productSubWindow;
		this.productRepository = productRepository;

		datefAanmaakDatum.setValue(LocalDateTime.now());


			cbArtikelNummerPomp1.addFocusListener( c -> {
				setCBArtikelNummerPomp();
			} );

		bAddProduct.addClickListener(f -> {

			productSubWindow.setDetailGegevenTicketViewInstance(this);
			UI.getCurrent().addWindow(productSubWindow);
			productSubWindow.setHeight("600px");
			productSubWindow.setWidth("1200px");
			productSubWindow.setModal(true);


		});

		tbBenodigdMateriaal.getEditor().setEnabled( true );

	}

	public void addSelectedProductsToTable(Collection<Product> selectedProducts){

		tbBenodigdMateriaal.setItems( selectedProducts )  ;
		tbBenodigdMateriaal.getDataProvider().refreshAll();
	}

	public void setCBArtikelNummerPomp(){
			artikelLijstOmschrijving = productRepository.findByOmschrijvingArtikelFabrikantContains("");
			cbArtikelNummerPomp1.setItems( artikelLijstOmschrijving );
			cbArtikelNummerPomp1.setItemCaptionGenerator( p -> p.getOmschrijvingArtikelFabrikant() );
}


	public DetailTicket saveDetailTicket() {


		detailTicket.setArtikelNummerInstallatie(tfArtikelNummer.getValue());
		detailTicket.setInstallatieJaar(Integer.parseInt(tfJaarInstallatie.getValue()));
		detailTicket.setInstallatieWeek(Integer.parseInt(tfWeekInstallatie.getValue()));
		detailTicket.setDetailAanmaakDatum(datefAanmaakDatum.getValue());
		detailTicket.setOmschrijvingInstallatie(taOmschrijvingInstallatie.getValue());

		//detailTicket.setArtikelNummerPomp(cbArtikelNummerPomp1.getValue());
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

		//cbArtikelNummerPomp1.setValue(detailTicket.getArtikelNummerPomp());
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

	public void setProductInProductTable(Collection<Product> selectedProducts){

		for (Iterator<Product> iter = selectedProducts.iterator(); iter.hasNext(); ) {
			productList.add( iter.next() );
		}
		tbBenodigdMateriaal.setItems( productList );

	}

}
