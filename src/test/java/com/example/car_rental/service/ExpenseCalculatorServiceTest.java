package com.example.car_rental.service;

import com.example.car_rental.enums.FuelType;
import com.example.car_rental.model.TripCost;
import com.example.car_rental.model.TripRequest;
import com.example.car_rental.enums.VehicleType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseCalculatorServiceTest {

    @Test
    public void testCalculateTripCostWithACAndPetrol() {
        ExpenseCalculatorService expenseCalculatorService = new ExpenseCalculatorService();

        TripRequest request = new TripRequest();
        request.setVehicleType(VehicleType.CAR.toString());
        request.setFuelType(FuelType.PETROL.toString());
        request.setDestination("Munich");
        request.setNumberOfPeople(5);
        request.setAirConditioningRequired(true);

        TripCost cost = expenseCalculatorService.calculateTripCost(request);
        assertEquals(175.20000000000002, cost.getTotalCost(), 0.01);
    }

}
