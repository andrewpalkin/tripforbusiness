package com.tripforbusiness.repository;

import com.tripforbusiness.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CountryRepository extends MongoRepository<Country, String> {

    List<Country> findByNameContains(String name);
}
