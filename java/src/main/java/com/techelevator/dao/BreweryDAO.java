package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDAO {

    Brewery getBreweryById(int id);

    boolean createNewBrewery(Brewery brewery);

    List<Brewery> getAllBreweries();

}
