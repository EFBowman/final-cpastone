package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDAO {

    Brewery getBreweryById(int id);

    boolean createNewBrewery(Brewery brewery);

    List<Brewery> getAllBreweries();

    List<Brewery> getAllBreweriesByCity(String city);

    List<Brewery> getAllBreweriesByState(String state);

    List<Brewery> getAllBreweriesByName(String name);

    List<Brewery> getAllBreweriesByType(String type);

    void updateBrewery(Brewery brewery, int id);

}
