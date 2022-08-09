package com.techelevator.controller;

import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Brewery;
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

        @ResponseStatus(value = HttpStatus.CREATED)
        @RequestMapping(path = "", method = RequestMethod.POST)
        public void create(@RequestBody @Valid Brewery brewery) {
            breweryDAO.createNewBrewery(brewery);
        }

        @RequestMapping(path = "", method = RequestMethod.GET)
        public List<Brewery> getAllBreweries() {
            return breweryDAO.getAllBreweries();
        }

}





















