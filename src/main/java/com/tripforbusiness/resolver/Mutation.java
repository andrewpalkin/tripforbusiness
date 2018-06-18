package com.tripforbusiness.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tripforbusiness.model.Site;
import com.tripforbusiness.repository.SiteRepository;

import java.util.Date;

public class Mutation implements GraphQLMutationResolver {

    private SiteRepository siteRepository;

    public Mutation(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public Site newSite(String cityId, String countryId, String name, String address, String description) {
        Site site = new Site();

        site.setCityId(cityId);
        site.setCountryId(countryId);
        site.setName(name);
        site.setDescription(description);
        site.setAddress(address);
        site.setCreated_at(new Date());
        site.setUpdated_at(new Date());

        return siteRepository.insert(site);
    }
}
