package com.tripforbusiness.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tripforbusiness.model.City;
import com.tripforbusiness.model.Country;
import com.tripforbusiness.model.CustomerSite;
import com.tripforbusiness.repository.CityRepository;
import com.tripforbusiness.repository.CountryRepository;
import com.tripforbusiness.repository.CustomerSiteRepository;

import java.util.List;
import java.util.Optional;

public class Query implements GraphQLQueryResolver {

    private CustomerSiteRepository customerSiteRepository;
    private CountryRepository countryRepository;
    private CityRepository cityRepository;

    public Query(CustomerSiteRepository customerSiteRepository,
                 CountryRepository countryRepository,
                 CityRepository cityRepository) {

        this.customerSiteRepository = customerSiteRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public List<CustomerSite> findAllCustomerSitesByCity(String cityId) {
        return customerSiteRepository.findAllByCityId(cityId);
    }

    public List<CustomerSite> findAllCustomerSitesByCountry(String countryId) {
        return customerSiteRepository.findAllByCountryId(countryId);
    }

    public Optional<CustomerSite> getCustomerSite(String id) {
        return customerSiteRepository.findById(id);
    }

    public Optional<Country> getCountry(String id){
        return countryRepository.findById(id);
    }

    public List<Country> getCountryByNameContains(String nameContains){
        return countryRepository.findByNameContains(nameContains);
    }

    public List<Country> findAllCountries(){
        return countryRepository.findAll();
    }

    public List<City> getCitiesByCountry(String countryId){
        return cityRepository.findByCountryId(countryId);
    }
}
