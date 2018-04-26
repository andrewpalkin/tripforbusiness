package com.tripforbusiness.repository;

import com.tripforbusiness.model.place.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlacesRepository extends MongoRepository<Place, String> {

}
