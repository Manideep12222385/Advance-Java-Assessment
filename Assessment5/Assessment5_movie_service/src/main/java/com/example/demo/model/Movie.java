package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    private Long id;
    private String name;
    private String language;
    private double price;

    public Movie() {}

    public Movie(Long id, String name, String language, double price) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.price = price;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLanguage() { return language; }

    public void setLanguage(String language) { this.language = language; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
