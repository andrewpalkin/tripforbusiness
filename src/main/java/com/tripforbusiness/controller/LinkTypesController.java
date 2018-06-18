package com.tripforbusiness.controller;

import com.tripforbusiness.model.LinkTypes;
import com.tripforbusiness.repository.LinkTypesRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/linkTypes")
public class LinkTypesController {

    @Autowired
    private LinkTypesRepository linkTypesRepository;

    @ApiOperation(value = "Add a link type")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody LinkTypes linkTypes)
    {
        linkTypesRepository.save(linkTypes);
    }

    @ApiOperation(value = "View a list of available link type")
    @RequestMapping(method = RequestMethod.GET)
    public List<LinkTypes> readAll()
    {
        return linkTypesRepository.findAll();
    }

    @ApiOperation(value = "Get a link type by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<LinkTypes> read(@PathVariable String id)
    {
        return linkTypesRepository.findById(id);
    }

    @ApiOperation(value = "Update details of exist link type")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(LinkTypes linkTypes)
    {
        linkTypesRepository.save(linkTypes);
    }

    @ApiOperation(value = "Delete a link type by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void delete(String id)
    {
        linkTypesRepository.deleteById(id);
    }
}
