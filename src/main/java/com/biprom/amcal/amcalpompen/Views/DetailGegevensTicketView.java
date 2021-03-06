package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.DetailTicketDesign;
import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.GridFS.GridFSService;
import com.biprom.amcal.amcalpompen.SubWindows.ProductSubWindow;
import com.biprom.amcal.amcalpompen.Upload.LineBreakCounter;
import com.biprom.amcal.amcalpompen.Upload.UploadInfoWindow;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.google.gwt.dev.PrecompileOnePerm;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.renderers.NumberRenderer;
import eu.maxschuster.vaadin.signaturefield.SignatureField;
import org.springframework.beans.factory.annotation.Autowired;
import org.tepi.imageviewer.ImageViewer;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;


public class DetailGegevensTicketView extends DetailTicketDesign implements View {

	public static final String VIEW_NAME = "ticketDetail";

	SignatureField signatureField = new SignatureField(  );

	LineBreakCounter lineBreakCounter = new LineBreakCounter();

	DetailTicket detailTicket = new DetailTicket();



	ProductSubWindow productSubWindow;
	ImageSubWindow imageSubWindow;
	ProductRepository productRepository;
	List<Product>artikelLijstOmschrijving;
	List<Product> productList = new ArrayList<>();
	TextField tfAantal = new TextField("0"  );
	TextField tfOmschrijvingAmcal = new TextField( "hellowkes");
	GridFSService gridFSService;
	File fileToDelete;
	DetailTicket dummyTicket;



	@Autowired
	public DetailGegevensTicketView(ImageSubWindow imageSubWindow, ProductSubWindow productSubWindow, ProductRepository productRepository, GridFSService gridFSService) {

		this.productSubWindow = productSubWindow;
		this.productRepository = productRepository;
		this.gridFSService = gridFSService;
		this.imageSubWindow = imageSubWindow;

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


		//TODO
		//save modified values to database instead just in the bean!!!

		Binder<Product> productBinder = tbBenodigdMateriaal.getEditor().getBinder();
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
		ulFoto.setButtonCaption( "bewaar bestand in dit datail" );

		ulFoto.addStartedListener( event -> {

		 });

		ulFoto.addFinishedListener( event -> {

			gridFSService.storeFileToMongoDB( "/Users/bramvandenberghe/uplPicToDB/"+event.getFilename(),"meta1", "meta2", event.getFilename(), detailTicket );
			fileToDelete = new File("/Users/bramvandenberghe/uplPicToDB/" + event.getFilename());

			try{

				fileToDelete = new File("/Users/bramvandenberghe/uplPicToDB/" + event.getFilename());

				if(fileToDelete.delete()){
					System.out.println(fileToDelete.getName() + " is deleted!");
				}else{
					System.out.println("Delete operation is failed.");
				}

			}catch(Exception e){

				e.printStackTrace();

			}

		});

		signatureField.setWidth( "350px" );
		signatureField.setHeight( "150px" );

		hLayoutSign.addComponent( signatureField );

		bReceivePictures.addClickListener(e -> {
			imageSubWindow.setImageResources( gridFSService.getResources() );
			UI.getCurrent().addWindow( imageSubWindow );
			imageSubWindow.setHeight( "600px" );
			imageSubWindow.setWidth( "1200px" );
			imageSubWindow.setModal( true );
		});


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

	public void setDetailTicketViewWithData(DetailTicket detailTicket1) {

		tfArtikelNummer.setValue(detailTicket1.getArtikelNummerInstallatie());
		tfJaarInstallatie.setValue(detailTicket1.getInstallatieJaar().toString());
		tfWeekInstallatie.setValue(detailTicket1.getInstallatieWeek().toString());
		datefAanmaakDatum.setValue(detailTicket1.getDetailAanmaakDatum());
		taOmschrijvingInstallatie.setValue(detailTicket1.getOmschrijvingInstallatie());

		//cbArtikelNummerPomp1.setValue(detailTicket1.getArtikelNummerPomp());
		tfJaarPomp.setValue(detailTicket1.getJaarPomp().toString());
		tfWeekPomp.setValue(detailTicket1.getWeekPomp().toString());
		taOmschrijvingPomp.setValue(detailTicket1.getOmschrijvingPomp());

		taVaststellingTechnieker.setValue(detailTicket1.getVaststellingTechnieker());
		taInterneOpmerkingen.setValue(detailTicket1.getInterneOpmerkingen());
		tfRamingUren.setValue("" + detailTicket1.getRamingUren());

		checkbOpdrachtAfgewerkt.setValue(detailTicket1.isOpdrachtAfgewerkt());
		checkbDeeltelijksFacturatie.setValue(detailTicket1.isTussentijdseFacturatieMogelijk());
		checkbVerderInTePlannen.setValue(detailTicket1.isVerderInTePlannen());

		checkbBestekGoedgekeurd.setValue( detailTicket1.isbBestekGoedgekeurd() );
		checkbHerstellingBestek.setValue( detailTicket1.isbHerstellingBestek() );
		checkbHerstellingUitvoer.setValue( detailTicket1.isbHerstellingUitvoer() );
		checkbInterventie.setValue( detailTicket1.isbInterventie() );
		checkbOfferte.setValue( detailTicket1.isbOfferte() );
		checkbOfferteGoedgekeurd.setValue( detailTicket1.isbOfferteGoedgekeurd() );

		gridFSService.findFilesForDetailTicket( detailTicket1 );

		dummyTicket = detailTicket1;
	}

	public void setProductInProductTable(Collection<Product> selectedProducts){

		for (Iterator<Product> iter = selectedProducts.iterator(); iter.hasNext(); ) {
			productList.add( iter.next() );
		}
		tbBenodigdMateriaal.setItems( productList );

	}


}
