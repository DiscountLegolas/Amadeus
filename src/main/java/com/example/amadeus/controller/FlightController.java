package com.example.amadeus.controller;
import com.example.amadeus.RequestSearch;
import com.example.amadeus.entity.Airport;
import com.example.amadeus.entity.Flight;
import com.example.amadeus.service.Airport.AirportService;
import com.example.amadeus.service.Flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @PostMapping("/Create")
    public ResponseEntity<Flight> save(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.saveFlight(flight));
    }
    @GetMapping("/Read")
    public ResponseEntity<List<Flight>> getAll() {
        return ResponseEntity.ok(flightService.fetchFlightList());
    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<Flight> update(@RequestBody Flight flight,
                                          @PathVariable("id") int flightid) {
        return ResponseEntity.ok(flightService.updateFlight(flight,flightid));
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int flightid) {
        flightService.deleteFlightById(flightid);
        return ResponseEntity.ok("Deleted Successfully");
    }
    @PostMapping("/search")
    public ResponseEntity<List<Flight>> search(@RequestBody RequestSearch search) {
        List<Flight> fs=new ArrayList<Flight>();
        List<Flight> flights=flightService.fetchFlightList();
        var fss=flights.stream().filter(x->x.getLandingairport().getAirportId()==search.landingairportid&&x.getTakeoffairport().getAirportId()==search.takeoffairportid).collect(Collectors.toList());
        var flightsbydatetime=fss.stream().filter(z->z.getTakeoffdatetime().toString().equals(search.takeoffdatetime.toString())).collect(Collectors.toList());
        for (var item:flightsbydatetime
             ) {
            if (item.getReturndatetime()==null){
                fs.add(item);
            }
            if (item.getReturndatetime()!=null&&search.returndatetime!=null&&item.getReturndatetime().toString().equals(search.returndatetime.toString())) {
                fs.add(item);
                fs.add(item);
            }
        }

        return ResponseEntity.ok(fs);
    }
}
