package com.biprom.amcal.amcalpompen.repositories;

import com.biprom.amcal.amcalpompen.Entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProductRepository extends PagingAndSortingRepository<Product, String> {


    List<Product>findByOmschrijvingArtikelFabrikantContains(String msg);
    List<Product>findByGewichtArtikelGreaterThan(Double gewicht);

}
