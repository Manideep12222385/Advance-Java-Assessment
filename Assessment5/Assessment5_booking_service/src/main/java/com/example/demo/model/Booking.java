package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {

    @Id
    private Long bookingId;
    private Long movieId;
    private int tickets;
    private double totalAmount;

    public Long getBookingId() { return bookingId; }

    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public int getTickets() { return tickets; }

    public void setTickets(int tickets) { this.tickets = tickets; }

    public double getTotalAmount() { return totalAmount; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}