package com.example.amadeus.service.Flight;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.entity.Flight;

import java.util.List;

public interface FlightService {
    Flight saveFlight(Flight flight);

    // Read operation
    List<Flight> fetchFlightList();

    // Update operation
    Flight updateFlight(Flight flight,
                          int flightid);

    // Delete operation
    void deleteFlightById(int flight);
}
