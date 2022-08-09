package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brewery Not Found")
public class BreweryNotFoundException extends RuntimeException{


}
