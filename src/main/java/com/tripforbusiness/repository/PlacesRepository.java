package com.tripforbusiness.repository;

import com.tripforbusiness.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlacesRepository extends MongoRepository<Place, String> {

}
