package com.example.amadeus.service.Airport;

import java.util.List;
import java.util.Objects;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.repository.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service

// Class
public class AirportServiceImpl
        implements AirportService {

    @Autowired
    private AirportRepo airportrepo;

    @Override
    public Airport saveAirport(Airport airport) {
        return airportrepo.save(airport);
    }

    @Override
    public List<Airport> fetchAirportList() {
        return  airportrepo.findAll();
    }

    @Override
    public Airport updateairport(Airport airport, int airportId) {
        Airport airportdb
                = airportrepo.findById(airportId)
                .get();
        if (Objects.nonNull(airport.getCity())
                && !"".equalsIgnoreCase(
                airport.getCity())) {
            airportdb.setCity(
                    airport.getCity());
        }
        return airportrepo.save(airportdb);
    }

    @Override
    public void deleteAirportById(int airportId) {
        airportrepo.deleteById(airportId);
    }

    // Save operation

}
