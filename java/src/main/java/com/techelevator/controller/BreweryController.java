package com.techelevator.controller;

import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Brewery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BreweryController {

        private BreweryDAO breweryDAO;

//    @RequestMapping(method = RequestMethod.POST)
//    public Auction create(@RequestBody Auction auction) {
//        return dao.create(auction);
//    }

        @RequestMapping(method = RequestMethod.POST)
        public void create(@RequestBody @Valid Brewery brewery) {
            breweryDAO.createNewBrewery(brewery);
        }

}





















