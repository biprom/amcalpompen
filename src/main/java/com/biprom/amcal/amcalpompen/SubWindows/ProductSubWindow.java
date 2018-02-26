package com.biprom.amcal.amcalpompen.SubWindows;

import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringComponent
@UIScope


public class ProductSubWindow extends Window {

    ProductRepository productRepository;

    ComboBox<Product>productComboBox;

    @Autowired
    public ProductSubWindow(ProductRepository productRepository) {

        super("selecteer het materiaal");

        this.productRepository = productRepository;

        center();

        setClosable( true );

        setContent( generateContent() );

        productComboBox = new ComboBox<Product>(  );

    }

    private VerticalLayout generateContent(){
        VerticalLayout verticalLayout = new VerticalLayout(  );
        HorizontalLayout upperHorizontalLayout = new HorizontalLayout(  );
        upperHorizontalLayout.setCaption( "selecteer het product dat u wil toevoegen" );
        upperHorizontalLayout.addComponentsAndExpand( productComboBox );
        verticalLayout.addComponent( upperHorizontalLayout );

        return verticalLayout;
    }
}
