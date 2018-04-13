package com.biprom.amcal.amcalpompen.repositories;

import com.biprom.amcal.amcalpompen.Entities.Artikel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Artikel, String> {
}
