package com.biprom.amcal.amcalpompen.repositories;

import com.biprom.amcal.amcalpompen.Entities.Klanten;
import com.biprom.amcal.amcalpompen.Entities.Personen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Klanten, String> {


    public Klanten findBybedrijfsNaam(String bedrijfsNaam);
    public List<Klanten> findBybedrijfsNaamStartsWith(String bedrijfsNaam);


}
