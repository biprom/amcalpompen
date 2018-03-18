package com.biprom.amcal.amcalpompen.SubWindows;

import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.Views.AddProductSubWindowView;
import com.biprom.amcal.amcalpompen.Views.DetailGegevensTicketView;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Window;


public class ProductSubWindow extends Window {

	ComboBox<Product> productComboBox;

	ProductRepository productRepository;

	AddProductSubWindowView addProductSubWindowView;

	DetailGegevensTicketView detailGegevensTicketView;

	public ProductSubWindow(ProductRepository repository, AddProductSubWindowView addProductSubWindowView) {

		this.productRepository = repository;
		this.addProductSubWindowView = addProductSubWindowView;

		setContent( addProductSubWindowView  );
		setWidth( "100%" );
	}



	public void setDetailGegevenTicketViewInstance(DetailGegevensTicketView detailGegevensTicketView) {

		this.detailGegevensTicketView = detailGegevensTicketView;
		addProductSubWindowView.setDetailGegevensTicketViewToAddProductSubwindow( detailGegevensTicketView );
	}



}
