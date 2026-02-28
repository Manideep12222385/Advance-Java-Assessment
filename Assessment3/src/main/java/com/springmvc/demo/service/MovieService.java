package com.springmvc.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.demo.exception.MovieNotFoundException;
import com.springmvc.demo.model.Movie;
import com.springmvc.demo.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() ->
                        new MovieNotFoundException("Movie not found with id: " + id));
    }

    public Movie newMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Integer id, Movie movie) {

        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new MovieNotFoundException("Movie not found with id: " + id));

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setReleaseYear(movie.getReleaseYear());
        existingMovie.setRating(movie.getRating());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Integer id) {

        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new MovieNotFoundException("Movie not found with id: " + id));

        movieRepository.delete(existingMovie);
    }
}