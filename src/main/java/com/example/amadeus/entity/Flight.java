package com.example.amadeus.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flightId;
    @ManyToOne()
    @JoinColumn(name="TAKEOFF_AİRPORT_ID")
    private Airport takeoffairport;
    @ManyToOne()
    @JoinColumn(name="LANDİNG_AİRPORT_ID")
    private Airport landingairport;
    private LocalDateTime takeoffdatetime;
    private LocalDateTime returndatetime;
    private Float Price;
}
