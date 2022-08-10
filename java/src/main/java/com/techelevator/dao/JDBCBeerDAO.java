package com.techelevator.dao;

import com.techelevator.model.Beer;
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
    public Beer getBeerById(int id){
        String sql = "SELECT * " +
                " FROM beer " +
                " WHERE beer_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToBeer(results);
        } else {
            throw new BreweryNotFoundException();
        }
    }

    @Override
    public boolean createNewBeer(Beer beer){
        String sql = "INSERT INTO beer (beer_id, brewery_id, beer_name, beer_description, image, abv, beer_type) " +
                "values (?, ?, ?, ?, ?, ?, ?) RETURNING beer_id;";
        Integer newBeerId;
        newBeerId = jdbcTemplate.queryForObject(sql, Integer.class, beer.getBeerId(), beer.getBreweryId(), beer.getBeerName(), beer.getBeerDescription(), beer.getImage(),
                 beer.getAbv(), beer.getBeerType());

        if(newBeerId == null) {
            return false;
        }
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

