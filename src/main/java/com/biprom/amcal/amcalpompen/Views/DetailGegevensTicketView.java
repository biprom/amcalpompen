package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.DetailTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.SubWindows.ProductSubWindow;
import com.biprom.amcal.amcalpompen.Upload.LineBreakCounter;
import com.biprom.amcal.amcalpompen.Upload.UploadInfoWindow;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.google.gwt.dev.PrecompileOnePerm;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.renderers.NumberRenderer;
import eu.maxschuster.vaadin.signaturefield.SignatureField;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;


public class DetailGegevensTicketView extends DetailTicketDesign implements View {

	public static final String VIEW_NAME = "ticketDetail";

	SignatureField signatureField = new SignatureField(  );

	LineBreakCounter lineBreakCounter = new LineBreakCounter();
	UploadInfoWindow uploadInfoWindow;

	DetailTicket detailTicket = new DetailTicket();

	ProductSubWindow productSubWindow;
	ProductRepository productRepository;
	List<Product>artikelLijstOmschrijving;
	List<Product> productList = new ArrayList<>();
	TextField tfAantal = new TextField("0"  );
	TextField tfOmschrijvingAmcal = new TextField( "hellowkes");



	@Autowired
	public DetailGegevensTicketView(ProductSubWindow productSubWindow, ProductRepository productRepository) {

		this.productSubWindow = productSubWindow;
		this.productRepository = productRepository;

		datefAanmaakDatum.setValue( LocalDateTime.now() );


		cbArtikelNummerPomp1.addFocusListener( c -> {
			setCBArtikelNummerPomp();
		} );

		bAddProduct.addClickListener( f -> {

			productSubWindow.setDetailGegevenTicketViewInstance( this );
			UI.getCurrent().addWindow( productSubWindow );
			productSubWindow.setHeight( "600px" );
			productSubWindow.setWidth( "1200px" );
			productSubWindow.setModal( true );


		} );


		tbBenodigdMateriaal.getEditor().setEnabled( true );

		Binder<Product> productBinder = tbBenodigdMateriaal.getEditor().getBinder();
		System.out.println( "binder = " +productBinder.toString() );
		tbBenodigdMateriaal.addColumn(Product::getAantal)
				.setCaption( "aantal" )
				.setEditorBinding(productBinder
						.forField(tfAantal)
						.withConverter(new StringToIntegerConverter("Dit is geen cijfer"))
						.bind(Product::getAantal, Product::setAantal)

				);



		tbBenodigdMateriaal.addColumn(Product::getOmschrijvingArtikelAmccal).setEditorComponent(tfOmschrijvingAmcal, Product::setOmschrijvingArtikelAmccal).setCaption("Omschrijving Amcal").setExpandRatio(2);
		tbBenodigdMateriaal.addColumn( Product::getOmschrijvingArtikelFabrikant ).setCaption("Omschrijving Grundfos");



		lineBreakCounter.setSlow( true );
		ulFoto.setReceiver( lineBreakCounter );

		ulFoto.setImmediateMode( false );
		ulFoto.setButtonCaption( "Upload File" );

		uploadInfoWindow = new UploadInfoWindow( ulFoto, lineBreakCounter );

		ulFoto.addStartedListener( event -> {

			if (uploadInfoWindow.getParent() == null) {
				UI.getCurrent().addWindow( uploadInfoWindow );
			}
			uploadInfoWindow.setClosable( false );
		} );
		ulFoto.addFinishedListener( event -> uploadInfoWindow.setClosable( true ) );

		signatureField.setWidth( "350px" );
		signatureField.setHeight( "150px" );

		hLayoutSign.addComponent( signatureField );

//		signatureField.addValueChangeListener( new Property.ValueChangeListener() {
//			@Override
//			public void valueChange(Property.ValueChangeEvent event) {
//				String signature = (String) event.getProperty().getValue();
//				// do something with the string
//			}
//		} );

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

		detailTicket.setbBestekGoedgekeurd( checkbBestekGoedgekeurd.getValue() );
		detailTicket.setbHerstellingBestek( checkbHerstellingBestek.getValue() );
		detailTicket.setbHerstellingUitvoer(  checkbHerstellingUitvoer.getValue());
		detailTicket.setbInterventie( checkbInterventie.getValue() );
		detailTicket.setbOfferte(checkbOfferte.getValue()  );
		detailTicket.setbOfferteGoedgekeurd( checkbOfferteGoedgekeurd.getValue() );

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

		checkbBestekGoedgekeurd.setValue( detailTicket.isbBestekGoedgekeurd() );
		checkbHerstellingBestek.setValue( detailTicket.isbHerstellingBestek() );
		checkbHerstellingUitvoer.setValue( detailTicket.isbHerstellingUitvoer() );
		checkbInterventie.setValue( detailTicket.isbInterventie() );
		checkbOfferte.setValue( detailTicket.isbOfferte() );
		checkbOfferteGoedgekeurd.setValue( detailTicket.isbOfferteGoedgekeurd() );

	}

	public void setProductInProductTable(Collection<Product> selectedProducts){

		for (Iterator<Product> iter = selectedProducts.iterator(); iter.hasNext(); ) {
			productList.add( iter.next() );
		}
		tbBenodigdMateriaal.setItems( productList );


		//tbBenodigdMateriaal.getColumn( "omschrijvingArtikelAmccal" ).setEditorComponent( textfield1);
		//tbBenodigdMateriaal.getColumn( "aantal" ).setEditorComponent( textfield2);
		//tbBenodigdMateriaal.getEditor().addSaveListener( e -> Notification.show( ("aantal is gewijzigd naar " + textfield2.getValue().toString()) ) );

		//Binder<Product>productBinder = tbBenodigdMateriaal.getEditor().getBinder();
		//Binder.Binding<Product, Integer> aantalBinder = productBinder.forField( textfield1 ).withConverter( new StringToIntegerConverter( "gelieve een nummer te plaatsen" ) ).bind( Product::getAantal, Product::setAantal );
		//tbBenodigdMateriaal.getColumn( "aantal" ).setEditorBinding( aantalBinder );
		//productBinder.readBean( new Product(5) );
	}

	//public void setProduct(Product product){
	//	this.product = product;
	//	this.productBinder.setBean( this.product );
	//}

}
