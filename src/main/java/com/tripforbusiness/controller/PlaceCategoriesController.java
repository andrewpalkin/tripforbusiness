package com.tripforbusiness.controller;

import com.tripforbusiness.model.PlaceCategories;
import com.tripforbusiness.repository.PlaceCategoriesRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/placeCategories")
public class PlaceCategoriesController {

    @Autowired
    private PlaceCategoriesRepository placeCategoriesRepository;

    @ApiOperation(value = "Add a place category")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody PlaceCategories placeCategories) {
        placeCategoriesRepository.save(placeCategories);
    }

    @ApiOperation(value = "View a list of available place categories")
    @RequestMapping(method = RequestMethod.GET)
    public List<PlaceCategories> readAll() {
        return placeCategoriesRepository.findAll();
    }

    @ApiOperation(value = "Get a place category by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<PlaceCategories> read(@PathVariable String id) {
        return placeCategoriesRepository.findById(id);
    }

    @ApiOperation(value = "Update details of exist place category")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(PlaceCategories placeCategories) {
        placeCategoriesRepository.save(placeCategories);
    }

    @ApiOperation(value = "Delete a place category by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(String id) {
        placeCategoriesRepository.deleteById(id);
    }
}
