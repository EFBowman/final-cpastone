package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.BeerNotFoundException;
import com.techelevator.model.Brewery;
import com.techelevator.model.BreweryNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCBeerDAO implements BeerDAO {

    private final JdbcTemplate jdbcTemplate;

    public JDBCBeerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createNewBeer(Beer beer){
        String sql = "INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type) " +
                "values (?, ?, ?, ?, ?, ?) RETURNING beer_id;";
        Integer newBeerId;
        newBeerId = jdbcTemplate.queryForObject(sql, Integer.class, beer.getBreweryId(), beer.getBeerName(), beer.getBeerDescription(), beer.getImage(),
                 beer.getAbv(), beer.getBeerType());
        if(newBeerId == null) {
            return false;
        }
        beer.setBeerId(newBeerId);
        return true;
    }

    @Override
    public List<Beer> getAllBeers() {
        List<Beer> beers = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM beer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public List<Beer> getBeersByBreweryId(int id) {
        List<Beer> beers = new ArrayList<>();

        String sql = "SELECT * " +
                " FROM beer " +
                "WHERE brewery_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while(results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public Beer getBeerById(int id){
        String sql = "SELECT * " +
                " FROM beer " +
                "WHERE beer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToBeer(results);
        } else {
            throw new BeerNotFoundException();
        }

    }

    private Beer mapRowToBeer(SqlRowSet results) {
        Beer newBeer = new Beer();
        newBeer.setBeerId(results.getInt("beer_id"));
        newBeer.setBreweryId(results.getInt("brewery_id"));
        newBeer.setBeerName(results.getString("beer_name"));
        newBeer.setBeerDescription(results.getString("beer_description"));
        newBeer.setImage(results.getString("image"));
        newBeer.setAbv(results.getDouble("abv"));
        newBeer.setBeerType(results.getString("beer_type"));

        return newBeer;

    }
}

