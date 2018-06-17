package com.tripforbusiness.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tripforbusiness.model.LinkTypes;
import com.tripforbusiness.model.PlaceCategories;
import com.tripforbusiness.model.User;
import com.tripforbusiness.model.place.Place;
import com.tripforbusiness.repository.LinkTypesRepository;
import com.tripforbusiness.repository.PlaceCategoriesRepository;
import com.tripforbusiness.repository.PlacesRepository;
import com.tripforbusiness.repository.UserRepository;

import java.util.Optional;

public class Query implements GraphQLQueryResolver {

    private UserRepository userRepository;
    private PlacesRepository placesRepository;
    private LinkTypesRepository linkTypesRepository;
    private PlaceCategoriesRepository placeCategoriesRepository;

    public Query(UserRepository userRepository,
                 PlacesRepository placesRepository,
                 LinkTypesRepository linkTypesRepository,
                 PlaceCategoriesRepository placeCategoriesRepository) {
        this.userRepository = userRepository;
        this.placesRepository = placesRepository;
        this.linkTypesRepository = linkTypesRepository;
        this.placeCategoriesRepository = placeCategoriesRepository;
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    public Iterable<Place> findAllPlaces() {
        return placesRepository.findAll();
    }

    public Optional<Place> getPlace(String id) {
        return placesRepository.findById(id);
    }

    public Iterable<LinkTypes> findAllLinkTypes() {
        return linkTypesRepository.findAll();
    }

    public Optional<LinkTypes> getLinkType(String id) {
        return linkTypesRepository.findById(id);
    }

    public Iterable<PlaceCategories> findAllPlaceCategories() {
        return placeCategoriesRepository.findAll();
    }

    public Optional<PlaceCategories> getPlaceCategory(String id) {
        return placeCategoriesRepository.findById(id);
    }

}
