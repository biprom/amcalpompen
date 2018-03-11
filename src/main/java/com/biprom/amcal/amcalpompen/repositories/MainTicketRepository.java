package com.biprom.amcal.amcalpompen.repositories;

import com.biprom.amcal.amcalpompen.Entities.MainTicket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainTicketRepository extends MongoRepository<MainTicket, String> {


}
