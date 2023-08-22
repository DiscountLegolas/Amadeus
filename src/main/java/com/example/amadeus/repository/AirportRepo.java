package com.example.amadeus.repository;

import com.example.amadeus.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface
public interface AirportRepo
        extends JpaRepository<Airport, Integer> {
}