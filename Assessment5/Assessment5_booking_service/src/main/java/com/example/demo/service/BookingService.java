package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.feign.MovieClient;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private MovieClient movieClient;

    public Booking createBooking(Booking booking) {
        // Get movie details from Movie Service
        var movie = movieClient.getMovie(booking.getMovieId());
        double price = Double.parseDouble(movie.get("price").toString());

        booking.setTotalAmount(price * booking.getTickets());

        // Save booking in database
        return repository.save(booking);
    }

    public List<Booking> getAllBookings(){
        // Fetch all bookings from database
        return repository.findAll();
    }
}