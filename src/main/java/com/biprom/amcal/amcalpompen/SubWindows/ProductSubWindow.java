package com.biprom.amcal.amcalpompen.SubWindows;

import com.biprom.amcal.amcalpompen.Entities.Product;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Window;


public class ProductSubWindow extends Window {

	ComboBox<Product> productComboBox;

	ProductRepository productRepository;


	public ProductSubWindow(ProductRepository repository) {
		this.productRepository = repository;
	}


}
