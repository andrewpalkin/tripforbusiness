package com.tripforbusiness.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tripforbusiness.model.City;
import com.tripforbusiness.model.Country;
import com.tripforbusiness.model.CustomerSite;
import com.tripforbusiness.repository.CityRepository;
import com.tripforbusiness.repository.CountryRepository;
import com.tripforbusiness.repository.CustomerSiteRepository;

import java.util.Date;

public class Mutation implements GraphQLMutationResolver {

    private CustomerSiteRepository customerSiteRepository;
    private CountryRepository countryRepository;
    private CityRepository cityRepository;

    public Mutation(CustomerSiteRepository customerSiteRepository,
                    CountryRepository countryRepository,
                    CityRepository cityRepository) {

        this.customerSiteRepository = customerSiteRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public CustomerSite newCustomerSite(String cityId,
                                        String countryId,
                                        String name,
                                        String address,
                                        String description) {

        CustomerSite customerSite = new CustomerSite();

        customerSite.setCityId(cityId);
        customerSite.setCountryId(countryId);
        customerSite.setName(name);
        customerSite.setDescription(description);
        customerSite.setAddress(address);
        customerSite.setCreated_at(new Date());
        customerSite.setUpdated_at(new Date());

        return customerSiteRepository.insert(customerSite);
    }

    public Country newCountry(String name,
                              String description) {
        Country country = new Country();
        country.setName(name);
        country.setDescription(description);
        country.setCreated_at(new Date());
        country.setUpdated_at(new Date());

        return countryRepository.insert(country);
    }

    public City newCity(String name,
                        String timeZone,
                        String countryId,
                        String description) {

        City city = new City();
        city.setName(name);
        city.setTimeZone(timeZone);
        city.setCountryId(countryId);
        city.setDescription(description);
        city.setCreated_at(new Date());
        city.setUpdated_at(new Date());

        return cityRepository.insert(city);
    }
}
