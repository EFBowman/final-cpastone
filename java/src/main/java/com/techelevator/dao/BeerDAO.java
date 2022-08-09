package com.techelevator.dao;

import com.techelevator.model.Beer;


import java.util.List;

public interface BeerDAO {

    Beer getBeerById(int id);

    boolean createNewBeer(Beer beer);

    List<Beer> getAllBeers();

}

