package com.techelevator.model;

import javax.validation.constraints.NotBlank;

public class SearchDTO {
    @NotBlank
    private String state = "";

    private String city = "";

    private String breweryType = "";


    public SearchDTO() {

    }

    public SearchDTO(String state, String city, String breweryType) {
        this.state = state;
        this.city = city;
        this.breweryType = breweryType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBreweryType() {
        return breweryType;
    }

    public void setBreweryType(String breweryType) {
        this.breweryType = breweryType;
    }


}
