package com.techelevator.controller;

import com.techelevator.dao.BeerDAO;
import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/")
@RestController
@CrossOrigin
public class BreweryController {
        @Autowired
        private BreweryDAO breweryDAO;

        @Autowired
        private BreweryService service;

        @ResponseStatus(value = HttpStatus.CREATED)
        @RequestMapping(path = "", method = RequestMethod.POST)
        public void create(@RequestBody @Valid Brewery brewery) {
            breweryDAO.createNewBrewery(brewery);
        }

        @RequestMapping(path = "/breweries", method = RequestMethod.GET)
        public List<Brewery> getAllBreweries() {
            return breweryDAO.getAllBreweries();
        }

        @RequestMapping(path= "/breweries/{id}", method = RequestMethod.GET)
        public Brewery getBreweryById(@PathVariable int id){ return breweryDAO.getBreweryById(id);}


        @ResponseStatus(value = HttpStatus.OK)
        @RequestMapping(path= "/breweries/{id}", method = RequestMethod.PUT)
        public void updateBrewery(@PathVariable int id, @RequestBody @Valid Brewery brewery)
        { breweryDAO.updateBrewery(brewery, id);}


}





















