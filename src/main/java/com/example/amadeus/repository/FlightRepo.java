package com.example.amadeus.repository;

import com.example.amadeus.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface
public interface FlightRepo
        extends JpaRepository<Flight, Integer> {
}