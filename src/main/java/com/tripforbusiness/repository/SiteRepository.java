package com.tripforbusiness.repository;

import com.tripforbusiness.model.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface  SiteRepository extends MongoRepository<Site,String > {

    List<Site> findAllByCityId(String cityId);

    List<Site> findAllByCountryId(String countryId);

    List<Site> findAllByCityIdAndCountryId (String cityId, String countryId);
}
