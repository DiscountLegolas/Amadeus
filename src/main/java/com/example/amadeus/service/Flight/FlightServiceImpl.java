package com.example.amadeus.service.Flight;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.entity.Flight;
import com.example.amadeus.repository.AirportRepo;
import com.example.amadeus.repository.FlightRepo;
import com.example.amadeus.service.Airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepo flightRepo;
    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    @Override
    public List<Flight> fetchFlightList() {
        return  flightRepo.findAll();
    }

    @Override
    public Flight updateFlight(Flight flight, int flightid) {
        Flight flightdbm
                = flightRepo.findById(flightid)
                .get();
        if (Objects.nonNull(flight.getLandingairport())) {
            flightdbm.setLandingairport(
                    flight.getLandingairport());
        }
        if (Objects.nonNull(flight.getTakeoffairport())) {
            flightdbm.setTakeoffairport(
                    flight.getTakeoffairport());
        }
        if (flight.getReturndatetime()!=null
                && !"".equalsIgnoreCase(
                String.valueOf(flight.getReturndatetime()))) {
            flightdbm.setReturndatetime(
                    flight.getReturndatetime());
        }
        if (Objects.nonNull(flight.getTakeoffdatetime())
                && !"".equalsIgnoreCase(
                String.valueOf(flight.getTakeoffdatetime()))) {
            flightdbm.setTakeoffdatetime(
                    flight.getTakeoffdatetime());
        }
        if (Objects.nonNull(flight.getPrice())
                && !"".equalsIgnoreCase(
                String.valueOf(flight.getPrice()))) {
            flightdbm.setPrice(
                    flight.getPrice());
        }
        return flightRepo.save(flightdbm);
    }

    @Override
    public void deleteFlightById(int flight) {
        flightRepo.deleteById(flight);
    }
}
