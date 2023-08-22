package com.example.amadeus.controller;
import com.example.amadeus.entity.Airport;
import com.example.amadeus.service.Airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;
    @PostMapping("/Create")
    public ResponseEntity<Airport> save(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.saveAirport(airport));
    }
    @GetMapping("/Read")
    public ResponseEntity<List<Airport>> getAll() {
        return ResponseEntity.ok(airportService.fetchAirportList());
    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<Airport> update(@RequestBody Airport airport,
                                                @PathVariable("id") int airportid) {
        return ResponseEntity.ok(airportService.updateairport(airport,airportid));
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int airportid) {
        airportService.deleteAirportById(airportid);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
