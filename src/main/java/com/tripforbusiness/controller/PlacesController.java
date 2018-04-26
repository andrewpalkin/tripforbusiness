package com.tripforbusiness.controller;

import com.tripforbusiness.model.place.Place;
import com.tripforbusiness.repository.PlacesRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlacesController {

    @Autowired
    private PlacesRepository placesRepository;

    @ApiOperation(value = "Add a place")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Place place) {
        placesRepository.save(place);
    }

    @ApiOperation(value = "View a list of available places")
    @RequestMapping(method = RequestMethod.GET)
    public List<Place> readAll() {
        return placesRepository.findAll();
    }

    @ApiOperation(value = "Get place by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Place> read(@PathVariable String id) {
        return placesRepository.findById(id);
    }

    @ApiOperation(value = "Update details of exist place")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(Place place) {
        placesRepository.save(place);
    }

    @ApiOperation(value = "Delete place by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(String id) {
        placesRepository.deleteById(id);
    }
}
