package com.techelevator.controller;

import com.techelevator.dao.BeerDAO;
import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.model.SearchDTO;
import com.techelevator.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@RequestMapping("/")
@RestController
@CrossOrigin
public class BreweryController {
        @Autowired
        private BreweryDAO breweryDAO;

        @Autowired
        private BreweryService service;

        @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
        @ResponseStatus(value = HttpStatus.CREATED)
        @RequestMapping(path = "", method = RequestMethod.POST)
        public void create(@RequestBody @Valid Brewery brewery) {
            breweryDAO.createNewBrewery(brewery);
        }

//        @RequestMapping(path = "/breweries/state={state}", method = RequestMethod.GET)
//        public List<Brewery> getAllBreweriesByState(@PathVariable String state) {
//                List<Brewery> allBreweries = new ArrayList<>();
//                List<Brewery> apiBreweries = service.searchBreweriesByState(state);
//                List<Brewery> dbBreweries = breweryDAO.getAllBreweriesByState(state);
//                allBreweries.addAll(apiBreweries);
//                allBreweries.addAll(dbBreweries);
//                return allBreweries;
//        }

        @RequestMapping(path="/breweries/search", method = RequestMethod.POST)
        public List<Brewery> getBreweriesBySearchParams(@RequestBody @Valid SearchDTO searchDTO) {
                List<Brewery> allBreweries = new ArrayList<>();
                List<Brewery> apiBreweries = service.searchBreweriesBySearchParams(searchDTO);
                List<Brewery> dbBreweries = breweryDAO.getAllBreweriesBySearchParams(searchDTO);
                allBreweries.addAll(dbBreweries);
                allBreweries.addAll(apiBreweries);
                return allBreweries;
        }

//        @RequestMapping(path = "/breweries/city={city}", method = RequestMethod.GET)
//        public List<Brewery> getAllBreweriesByCity(@PathVariable String city) {
//                List<Brewery> allBreweries = new ArrayList<>();
//                List<Brewery> apiBreweries = service.searchBreweriesByCity(city);
//                List<Brewery> dbBreweries = breweryDAO.getAllBreweriesByCity(city);
//                allBreweries.addAll(apiBreweries);
//                allBreweries.addAll(dbBreweries);
//                return allBreweries;
//        }

//        @RequestMapping(path = "/breweries/name={name}", method = RequestMethod.GET)
//        public List<Brewery> getAllBreweriesByName(@PathVariable String name) {
//                List<Brewery> allBreweries = new ArrayList<>();
//                List<Brewery> apiBreweries = service.searchBreweriesByName(name);
//                List<Brewery> dbBreweries = breweryDAO.getAllBreweriesByName(name);
//                allBreweries.addAll(apiBreweries);
//                allBreweries.addAll(dbBreweries);
//                return allBreweries;
//        }

//        @RequestMapping(path = "/breweries/type={type}", method = RequestMethod.GET)
//        public List<Brewery> getAllBreweriesByType(@PathVariable String type) {
//                List<Brewery> allBreweries = new ArrayList<>();
//                List<Brewery> apiBreweries = service.searchBreweriesByType(type);
//                List<Brewery> dbBreweries = breweryDAO.getAllBreweriesByType(type);
//                allBreweries.addAll(apiBreweries);
//                allBreweries.addAll(dbBreweries);
//                return allBreweries;
//        }

        //Singular brewery in path
        @RequestMapping(path= "/brewery/{id}", method = RequestMethod.GET)
        public Brewery getBreweryById(@PathVariable String id){ return breweryDAO.getBreweryById(id);}


        @ResponseStatus(value = HttpStatus.OK)
        @RequestMapping(path= "/breweries/{id}", method = RequestMethod.PUT)
        public void updateBrewery(@PathVariable String id, @RequestBody @Valid Brewery brewery)
        { breweryDAO.updateBrewery(brewery, id);}

        @RequestMapping(path = "/breweries", method = RequestMethod.GET)
        public List<Brewery> getAllBreweries(){ return breweryDAO.getAllBreweries();}


        //Singular brewery in path
        @RequestMapping(path = "/brewery/beer/{id}", method = RequestMethod.GET)
        public String getBreweryNameByBeerId(@PathVariable int id) {
                return breweryDAO.getBreweryNameByBeerId(id);
        }



}





















