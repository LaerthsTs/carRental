package com.example.car_rental.service;


import com.example.car_rental.enums.FuelType;
import com.example.car_rental.model.TripCost;
import com.example.car_rental.model.TripRequest;
import com.example.car_rental.enums.VehicleType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ExpenseCalculatorService {

    private static final double STANDARD_RATE = 0.20;
    private static final double DIESEL_DISCOUNT = 0.05;
    private static final double AC_CHARGE = 0.10;
    private static final double EXTRA_PASSENGER_CHARGE = 0.05;
    private static final double BUS_DISCOUNT = 0.02;

    private static final Map<String, Integer> distances;
    private static final Map<String, Integer> vehicleCapacities;

    static {
        distances = new HashMap<>();
        distances.put("Berlin", 0);
        distances.put("Munich", 584);
        distances.put("Hamburg", 289);
        distances.put("Frankfurt", 545);
        distances.put("Cologne", 576);

        vehicleCapacities = new HashMap<>();
        vehicleCapacities.put(VehicleType.SUV.toString(), 8);
        vehicleCapacities.put(VehicleType.CAR.toString(), 5);
        vehicleCapacities.put(VehicleType.VAN.toString(), 12);
        vehicleCapacities.put(VehicleType.BUS.toString(), 50);
    }

    public TripCost calculateTripCost(TripRequest tripRequest) {
        String destination = tripRequest.getDestination();
        int distance = distances.getOrDefault(destination, 0);
        double costPerKm = STANDARD_RATE;

        if (Objects.equals(tripRequest.getFuelType(), FuelType.DIESEL.toString())) {
            costPerKm -= DIESEL_DISCOUNT;
        }

        if (tripRequest.isAirConditioningRequired()) {
            costPerKm += AC_CHARGE;
        }

        if (Objects.equals(tripRequest.getVehicleType(), VehicleType.BUS.toString())) {
            costPerKm -= costPerKm * BUS_DISCOUNT;
        }

        int maxCapacity = vehicleCapacities.getOrDefault(tripRequest.getVehicleType(), 0);
        if (tripRequest.getNumberOfPeople() > maxCapacity) {
            costPerKm += (tripRequest.getNumberOfPeople() - maxCapacity) * EXTRA_PASSENGER_CHARGE;
        }

        double totalCost = distance * costPerKm;
        return new TripCost(totalCost);
    }
}
