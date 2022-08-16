package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;
import org.springframework.stereotype.Component;


import java.util.List;

public interface BeerDAO {

    Beer getBeerById(int id);

    boolean createNewBeer(Beer beer);

    List<Beer> getAllBeers();

    List<Beer> getBeersByBreweryId(int id);

    List<Review> getAllReviewsByBeerId(int id);

    boolean addReview(Review review);

}

