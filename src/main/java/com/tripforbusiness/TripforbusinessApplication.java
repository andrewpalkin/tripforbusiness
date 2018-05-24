package com.tripforbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tripforbusiness"})
public class TripforbusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripforbusinessApplication.class, args);
    }

}
