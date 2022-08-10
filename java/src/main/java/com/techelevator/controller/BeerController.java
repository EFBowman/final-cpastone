package com.techelevator.controller;

import com.techelevator.dao.BeerDAO;
import com.techelevator.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/")
@RestController
@CrossOrigin

public class BeerController {

    @Autowired
    private BeerDAO beerDAO;


    // @PreAuthorize("beer lover")

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "/beers", method = RequestMethod.POST)
    public void create(@RequestBody @Valid Beer beer) {
        beerDAO.createNewBeer(beer);
    }

}
