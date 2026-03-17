package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;



@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping
    public Booking bookTicket(@RequestBody Booking booking) {
        return service.createBooking(booking);
    }
    
    @GetMapping
    public List<Booking> getAllBookings(){
    		return service.getAllBookings();
    }
}