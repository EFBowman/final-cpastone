package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDAO {

    Brewery getBreweryById(int id);

     void createNewBrewery(Brewery brewery);

    List<Brewery> getAllBreweries();

}
