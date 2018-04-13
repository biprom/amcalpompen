package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.AddProductSubWindowDesign;
import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddProductSubWindowView extends AddProductSubWindowDesign{

    ApplicationContext context;
    ProductRepository productRepository;
    DetailGegevensTicketView detailGegevensTicketView;
    List<Product>products;
    List <Product> selectedProducts;
    String rightBeanInstance;

@Autowired
    public AddProductSubWindowView(ProductRepository productRepository, ApplicationContext context) {

    this.productRepository = productRepository;
    this.context = context;

    gridProducts.setSelectionMode( Grid.SelectionMode.MULTI );
    gridProducts.addComponentColumn( link ->  new Link("Click Me!",
            new ExternalResource(link.getLinkGrundfos()))).setWidth(150 );
    gridProducts.setColumnOrder("omschrijvingArtikelFabrikant","omschrijvingArtikelAmccal","artikelNummer","bruto2018","korting","prijsGroep2018" );
    gridProducts.removeColumn( "linkGrudfos" );
    gridProducts.removeColumn( "prijsGroep2018" );
    gridProducts.removeColumn( "eANNummer" );
    gridProducts.removeColumn( "artikelGebruikt" );
    gridProducts.removeColumn( "aantal" );


    tfFilter.addValueChangeListener( e -> setDataInProductGrid() );
    tfFilter.setValueChangeMode( ValueChangeMode.LAZY );

    bClearFilter.addClickListener( f -> tfFilter.clear() );

    bAddProduct.addClickListener( e -> {

        detailGegevensTicketView.setProductInProductTable( gridProducts.getSelectedItems() );

    } );

    }


    public void setDataInProductGrid(){
        products =(List<Product>) productRepository.findByOmschrijvingArtikelFabrikantContains(tfFilter.getValue());
        gridProducts.setItems(products);
    }

    public void setDetailGegevensTicketViewToAddProductSubwindow(DetailGegevensTicketView detailGegevensTicketView){
        this.detailGegevensTicketView = detailGegevensTicketView;
    }


}
