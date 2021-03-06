package com.biprom.amcal.amcalpompen.Configuration;

import com.biprom.amcal.amcalpompen.GridFS.GridFSService;
import com.biprom.amcal.amcalpompen.SubWindows.ProductSubWindow;
import com.biprom.amcal.amcalpompen.Views.AddProductSubWindowView;
import com.biprom.amcal.amcalpompen.Views.DetailGegevensTicketView;
import com.biprom.amcal.amcalpompen.Views.ImageSubWindow;
import com.biprom.amcal.amcalpompen.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DetailGegevensTicketConf {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	AddProductSubWindowView addProductSubWindowView;
	@Autowired
	GridFSService gridFSService;

	@Bean
	@Scope("prototype")
	public DetailGegevensTicketView getDetailGegevensTicketView() {
		return new DetailGegevensTicketView(imageSubWindow(),productSubWindow(), productRepository, gridFSService);
	}

	@Bean
	@Scope("prototype")
	public ProductSubWindow productSubWindow() {
		return new ProductSubWindow(productRepository, addProductSubWindowView);
	}

	@Bean
	@Scope("prototype")
	public ImageSubWindow imageSubWindow() {
		return new ImageSubWindow();
	}

}
