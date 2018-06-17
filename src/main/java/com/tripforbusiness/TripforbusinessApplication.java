package com.tripforbusiness;

import com.tripforbusiness.repository.LinkTypesRepository;
import com.tripforbusiness.repository.PlaceCategoriesRepository;
import com.tripforbusiness.repository.PlacesRepository;
import com.tripforbusiness.repository.UserRepository;
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
    public Query query(UserRepository userRepository,
                       PlacesRepository placesRepository,
                       LinkTypesRepository linkTypesRepository,
                       PlaceCategoriesRepository placeCategoriesRepository) {

        return new Query(userRepository,
                placesRepository,
                linkTypesRepository,
                placeCategoriesRepository);
    }

}
