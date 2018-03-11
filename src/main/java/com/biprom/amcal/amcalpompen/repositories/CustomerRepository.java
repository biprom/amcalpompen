package com.biprom.amcal.amcalpompen.repositories;

import com.biprom.amcal.amcalpompen.Entities.Klanten;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Klanten, String> {

	public Klanten findBybedrijfsNaam(String bedrijfsNaam);

	public List<Klanten> findBybedrijfsNaamStartsWith(String bedrijfsNaam);


}
