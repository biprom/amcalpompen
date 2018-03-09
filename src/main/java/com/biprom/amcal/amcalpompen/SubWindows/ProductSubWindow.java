package com.biprom.amcal.amcalpompen.SubWindows;

import com.biprom.amcal.amcalpompen.Configuration.DetailGegevensTicketConf;
import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.repositories.CustomerRepository;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ProductSubWindow extends Window {

    ComboBox<Product>productComboBox;
    ProductRepository productRepository;


    public ProductSubWindow() {



    }



}
