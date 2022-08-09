package com.techelevator.model;

import javax.validation.constraints.NotBlank;

public class Beer {

    private int beerId;
    private int breweryId;
    @NotBlank
    private String beerName;
    private String beerDescription;
    private String image;
    private double abv;
    @NotBlank
    private String beerType;

    public Beer() {

    }

    public Beer(int beerId, int breweryId, String beerName, String beerType){
        this.beerId = beerId;
        this.breweryId = breweryId;
        this.beerName = beerName;
        this.beerType = beerType;
    }

    public Beer(int beerId, int breweryId, String beerName, String beerDescription,
                String image, double abv, String beerType) {
        this.beerId = beerId;
        this.breweryId = breweryId;
        this.beerName = beerName;
        this.beerDescription = beerDescription;
        this.image = image;
        this.abv = abv;
        this.beerType = beerType;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBeerDescription() {
        return beerDescription;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }
}
