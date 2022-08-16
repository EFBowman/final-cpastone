package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Review {

    @NotEmpty
    private int reviewId;
    @NotEmpty
    private int userId;
    @NotEmpty
    private int beerId;
    @NotBlank
    private String beerName;
    @NotBlank
    private String breweryName;
    private String description;
    @NotEmpty
    private int rating;

    public Review() {

    }

    public Review(int reviewId, int userId, int beerId, String beerName,
                  String breweryName, String description, int rating) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.beerId = beerId;
        this.beerName = beerName;
        this.breweryName = breweryName;
        this.description = description;
        this.rating = rating;
    }

    public Review(int reviewId, int userId, int beerId, String beerName,
                  String breweryName, int rating) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.beerId = beerId;
        this.beerName = beerName;
        this.breweryName = breweryName;
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
