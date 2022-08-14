package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Brewery {
    @JsonProperty("id")
    private String breweryId;
    private int brewerId;
    @NotBlank
    private String name;
    @JsonProperty ("phone")
    private String phoneNumber;
    @JsonProperty ("website_url")
    private String url;
    private String street;
    private String city;
    private String state;
    private String history;
    private String openHours;
    private String image;
    @NotBlank
    @JsonProperty("brewery_type")
    private String breweryType;

    public String getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(String breweryId) {
        this.breweryId = breweryId;
    }

    public int getBrewerId() {
        return brewerId;
    }

    public void setBrewerId(int brewerId) {
        this.brewerId = brewerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBreweryType() {
        return breweryType;
    }

    public void setBreweryType(String breweryType) {
        this.breweryType = breweryType;
    }

    public Brewery(String breweryId, int brewerId, String name,
                   String phoneNumber, String url,
                   String streetAddress, String city, String state, String history,
                   String openHours, String image,
                   String breweryType) {
        this.breweryId = breweryId;
        this.brewerId = brewerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.url = url;
        this.street = streetAddress;
        this.city = city;
        this.state = state;
        this.history = history;
        this.openHours = openHours;
        this.image = image;
        this.breweryType = breweryType;
    }

    public Brewery(String breweryId, int brewerId, String name,
                   String phoneNumber,
                   String streetAddress,
                   String city,
                   String state,
                   String openHours,
                   String breweryType) {
        this.breweryId = breweryId;
        this.brewerId = brewerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.street = streetAddress;
        this.city = city;
        this.state = state;
        this.openHours = openHours;
        this.breweryType = breweryType;
    }

    public Brewery() {

    }
}
