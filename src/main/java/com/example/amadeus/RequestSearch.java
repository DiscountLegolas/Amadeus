package com.example.amadeus;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class RequestSearch {
    public int takeoffairportid;
    public int landingairportid;
    public LocalDateTime takeoffdatetime;
    public LocalDateTime returndatetime;

}
