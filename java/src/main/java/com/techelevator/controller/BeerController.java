package com.techelevator.controller;

import com.techelevator.dao.BeerDAO;
import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/")
@RestController
@CrossOrigin

public class BeerController {

    @Autowired
    private BeerDAO beerDAO;


    // @PreAuthorize("brewer")

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "/beers", method = RequestMethod.POST)
    public void create(@RequestBody @Valid Beer beer) {
        beerDAO.createNewBeer(beer);
    }

}
