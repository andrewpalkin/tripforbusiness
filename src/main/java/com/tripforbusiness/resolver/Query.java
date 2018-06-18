package com.tripforbusiness.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tripforbusiness.model.*;
import com.tripforbusiness.repository.SiteRepository;

import java.util.List;
import java.util.Optional;

public class Query implements GraphQLQueryResolver {

    private SiteRepository siteRepository;

    public Query(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public List<Site> findAllSitesByCity(String cityId) {
        return siteRepository.findAllByCityId(cityId);
    }

    public List<Site> findAllSitesByCountry(String countryId) {
        return siteRepository.findAllByCountryId(countryId);
    }

    public Optional<Site> getSite(String id) {
        return siteRepository.findById(id);
    }

}
