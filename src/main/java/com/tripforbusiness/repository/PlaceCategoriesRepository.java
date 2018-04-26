package com.tripforbusiness.repository;

import com.tripforbusiness.model.PlaceCategories;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceCategoriesRepository extends MongoRepository <PlaceCategories,String >{

}
