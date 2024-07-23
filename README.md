# Car Rental

# Features
- Exposes a REST API endpoint for calculating trip costs.

- Endpoint: POST /api/rental/calculate
  - Request Body: json,
    {
      "vehicleType": (String): Type of the vehicle (e.g., "SUV", "CAR", "VAN", "BUS"),
      "fuelType": (String): Type of the fuel (e.g., "PETROL", "DIESEL"),
      "destination": (String),
      "numberOfPeople": (int),
      "isAirConditioningRequired": (boolean)
    }
