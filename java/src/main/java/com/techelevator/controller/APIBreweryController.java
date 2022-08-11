package com.techelevator.controller;

import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("https://api.openbrewerydb.org/breweries?")
@RestController
@CrossOrigin
public class APIBreweryController {

    @Autowired
    private BreweryDAO breweryDAO;

    @RequestMapping(path="by_state={stateName}", method = RequestMethod.GET)
    public List<Brewery> getBreweriesByState(@PathVariable String stateName) {
        String finalStateName = "";
        if(stateName.contains("_")) {
            String[] splitState = stateName.split("_");
            finalStateName = splitState[0] + " " + splitState[1];
            return breweryDAO.getAllBreweriesByState(finalStateName);
        }
        return breweryDAO.getAllBreweriesByState(stateName);
    }

    @RequestMapping(path="by_city={cityName}", method = RequestMethod.GET)
    public List<Brewery> getBreweriesByCity(@PathVariable String cityName) {
        String finalCityName = "";
        if(cityName.contains("_")) {
            String[] splitCity = cityName.split("_");
            for(int i = 0; i < splitCity.length; i++) {
                finalCityName += splitCity[i];
            }
            return breweryDAO.getAllBreweriesByState(finalCityName);
        }
        return breweryDAO.getAllBreweriesByState(cityName);
    }

    @RequestMapping(path="by_name={breweryName}", method = RequestMethod.GET)
    public List<Brewery> getBreweriesByName(@PathVariable String breweryName) {
        String finalBreweryName = "";
        if(breweryName.contains("_")) {
            String[] splitBrewery = breweryName.split("_");
            for(int i = 0; i < splitBrewery.length; i++) {
                finalBreweryName += splitBrewery[i];
            }
            return breweryDAO.getAllBreweriesByState(finalBreweryName);
        }
        return breweryDAO.getAllBreweriesByState(breweryName);
    }

    @RequestMapping(path="by_type={type}", method = RequestMethod.GET)
    public List<Brewery> getBreweriesByType(@PathVariable String type) {
        return breweryDAO.getAllBreweriesByType(type);
    }

}
