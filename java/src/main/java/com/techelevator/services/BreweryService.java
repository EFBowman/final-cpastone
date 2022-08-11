package com.techelevator.services;

import com.techelevator.model.Brewery;
import org.springframework.web.client.RestTemplate;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.List;

public class BreweryService {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String baseURL = "https://api.openbrewerydb.org/breweries?";

    private static final String byState = "by_state=";

    private static final String byCity = "by_city=";

    private static final String byName = "by_name=";

    private static final String byType = "by_type=";

    public List<Brewery> searchBreweriesByState(String state) {
        String url = baseURL + byState + state;
        List<Brewery> breweries = new ArrayList<>();
        Brewery brewery = restTemplate.getForObject(url, Brewery.class);
        while(brewery.next()){
            breweries.add(brewery);
        }
        return breweries;
    }



}
