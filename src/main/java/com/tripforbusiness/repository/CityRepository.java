package com.tripforbusiness.repository;

import com.tripforbusiness.model.City;
import com.tripforbusiness.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends MongoRepository<City, String> {

    List<City> findByNameContains(String name);

    List<City> findByCountryId(String countryId);
}
