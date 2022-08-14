package com.techelevator.services;

import com.techelevator.model.Brewery;
import com.techelevator.model.SearchDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.naming.directory.SearchResult;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class BreweryService {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String baseURL = "https://api.openbrewerydb.org/breweries?";

    private static final String byState = "by_state=";

    private static final String byCity = "by_city=";

    private static final String byName = "by_name=";

    private static final String byType = "by_type=";

    public List<Brewery> searchBreweriesByState(String state) {
        String url = baseURL + byState + state;
        Brewery[] breweries = restTemplate.getForObject(url, Brewery[].class);
        List<Brewery> breweryList = Arrays.asList(breweries);
        return breweryList;
    }
    public List<Brewery> searchBreweriesByCity(String city) {
        String url = baseURL + byCity + city;
        Brewery[] breweries = restTemplate.getForObject(url, Brewery[].class);
        List<Brewery> breweryList = Arrays.asList(breweries);
        return breweryList;
    }
    public List<Brewery> searchBreweriesByName(String name) {
        String url = baseURL + byName + name;
        Brewery[] breweries = restTemplate.getForObject(url, Brewery[].class);
        List<Brewery> breweryList = Arrays.asList(breweries);
        return breweryList;
    }
    public List<Brewery> searchBreweriesByType(String type) {
        String url = baseURL + byType + type;
        Brewery[] breweries = restTemplate.getForObject(url, Brewery[].class);
        List<Brewery> breweryList = Arrays.asList(breweries);
        return breweryList;
    }

    public List<Brewery> searchBreweriesBySearchParams(SearchDTO searchDTO) {
        String url = baseURL;
        List<Brewery> breweryList = new ArrayList<>();
        if(!searchDTO.getCity().equals("") && !searchDTO.getBreweryType().equals("")) {

            url += byState + searchDTO.getState() + "&" + byCity + searchDTO.getCity() + "&" + byType + searchDTO.getBreweryType();
            Brewery[] breweries = restTemplate.getForObject(url, Brewery[].class);
            breweryList = Arrays.asList(breweries);
            return breweryList;
        } else if (!searchDTO.getCity().equals("")){

            url += byState + searchDTO.getState() + "&" + byCity + searchDTO.getCity();
            Brewery[] breweries = restTemplate.getForObject(url, Brewery[].class);
            breweryList = Arrays.asList(breweries);
            return breweryList;
        } else if (!searchDTO.getBreweryType().equals("")) {

            url += byState + searchDTO.getState() + "&" + byType + searchDTO.getBreweryType();
            Brewery[] breweries = restTemplate.getForObject(url, Brewery[].class);
            breweryList = Arrays.asList(breweries);
            return breweryList;
        } else {
            url += byState + searchDTO.getState();
            Brewery[] breweries = restTemplate.getForObject(url, Brewery[].class);
            breweryList = Arrays.asList(breweries);
        }
        return breweryList;
    }


}
