package com.biprom.amcal.amcalpompen.SubWindows;

import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.repositories.CustomerRepository;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProductSubWindow extends Window {

    //@Autowired
   // TestClass testClass;

    ComboBox<Product>productComboBox;

    public ProductSubWindow() {

        //testClass.setMessage( "Inderdaad dit is hij zeker :-)" );

        productComboBox = new ComboBox<Product>(  );

        setContent( productComboBox );


    }


}
