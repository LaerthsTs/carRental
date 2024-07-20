package com.example.car_rental.model;


import lombok.Data;

@Data
public class TripRequest {

    private String vehicleType;
    private String fuelType;
    private String destination;
    private int numberOfPeople;
    private boolean isAirConditioningRequired;
}
