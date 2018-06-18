package com.tripforbusiness;

import com.tripforbusiness.repository.SiteRepository;
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
    public Query query(SiteRepository siteRepository) {
        return new Query(siteRepository);
    }

    @Bean
    public Mutation mutation(SiteRepository siteRepository) {
        return new Mutation(siteRepository);
    }
}
