package com.techelevator.dao;

import com.techelevator.model.*;
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

    @Override
    public List<Review> getAllReviewsByBeerId(int id) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review " +
                "WHERE beer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while(results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }


    @Override
    public int getBeerIdByName(String name) {
        String sql = "SELECT beer_id FROM beer " +
                "WHERE beer_name = ?;";
        int beerId = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return beerId;
    }

    @Override
    public boolean addReview(Review review) {
        String sql = "INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING review_id;";
        Integer newReviewId;
        newReviewId = jdbcTemplate.queryForObject(sql, Integer.class, review.getUserId(), review.getBeerId(), review.getBeerName(), review.getBreweryName(),
                review.getDescription(), review.getRating());
        if(newReviewId == null) {
            return false;
        }
        review.setReviewId(newReviewId);
        return true;

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

    private Review mapRowToReview(SqlRowSet results) {
        Review review = new Review();
        review.setReviewId(results.getInt("review_id"));
        review.setUserId(results.getInt("user_id"));
        review.setBeerId(results.getInt("beer_id"));
        review.setBeerName(results.getString("beer_name"));
        review.setBreweryName(results.getString("brewery_name"));
        review.setDescription(results.getString("description"));
        review.setRating(results.getInt("rating"));
        return review;

    }

}

