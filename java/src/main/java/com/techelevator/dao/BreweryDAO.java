package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.SearchDTO;

import java.util.List;

public interface BreweryDAO {

    Brewery getBreweryById(String id);

    boolean createNewBrewery(Brewery brewery);

    List<Brewery> getAllBreweriesBySearchParams(SearchDTO searchDTO);

    List<Brewery> getAllBreweriesByCity(String city);

    List<Brewery> getAllBreweriesByState(String state);

    List<Brewery> getAllBreweriesByName(String name);

    List<Brewery> getAllBreweriesByType(String type);

    void updateBrewery(Brewery brewery, String id);

    List<Brewery> getAllBreweries();

    Brewery getBreweryByPhoneNumber(String phoneNumber);

}
