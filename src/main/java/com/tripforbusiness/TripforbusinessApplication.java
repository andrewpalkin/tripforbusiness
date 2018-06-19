package com.tripforbusiness;

import com.tripforbusiness.repository.CityRepository;
import com.tripforbusiness.repository.CountryRepository;
import com.tripforbusiness.repository.CustomerSiteRepository;
import com.tripforbusiness.resolver.Mutation;
import com.tripforbusiness.resolver.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.tripforbusiness"})
public class TripforbusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripforbusinessApplication.class, args);
    }

    @Bean
    public Query query(CustomerSiteRepository customerSiteRepository,
                       CountryRepository countryRepository,
                       CityRepository cityRepository) {
        return new Query(customerSiteRepository, countryRepository, cityRepository);
    }

    @Bean
    public Mutation mutation(CustomerSiteRepository customerSiteRepository,
                             CountryRepository countryRepository,
                             CityRepository cityRepository) {
        return new Mutation(customerSiteRepository, countryRepository, cityRepository);
    }
}
