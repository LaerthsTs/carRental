package com.example.car_rental.controller;


import com.example.car_rental.model.TripCost;
import com.example.car_rental.model.TripRequest;
import com.example.car_rental.service.ExpenseCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rental")
public class CarRentalController {

    @Autowired
    private ExpenseCalculatorService expenseCalculatorService;

    @PostMapping("/calculate")
    public TripCost calculateTripCost(@RequestBody TripRequest tripRequest) {
        return expenseCalculatorService.calculateTripCost(tripRequest);
    }
}
