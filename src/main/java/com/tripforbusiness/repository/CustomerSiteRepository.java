package com.tripforbusiness.repository;

import com.tripforbusiness.model.CustomerSite;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerSiteRepository extends MongoRepository<CustomerSite,String > {

    List<CustomerSite> findAllByCityId(String cityId);

    List<CustomerSite> findAllByCountryId(String countryId);

    List<CustomerSite> findAllByCityIdAndCountryId (String cityId, String countryId);
}
