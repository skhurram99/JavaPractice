package com.practice.movie.controller;

import com.practice.movie.model.Movie;
import com.practice.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie")
    public Mono<Movie> getMovie(){
        return movieService.getMovieRatingById(1);
    }
}
