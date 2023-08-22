package com.example.amadeus.service.Airport;

import com.example.amadeus.entity.Airport;

import java.util.List;

// Interface
public interface AirportService {

    // Save operation
    Airport saveAirport(Airport airport);

    // Read operation
    List<Airport> fetchAirportList();

    // Update operation
    Airport updateairport(Airport airport,
                                int airportId);

    // Delete operation
    void deleteAirportById(int airportId);
}