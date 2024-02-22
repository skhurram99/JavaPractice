package com.practice.ratings.controller;

import com.practice.ratings.Service.RatingsService;
import com.practice.ratings.model.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RatingsController {

    @Autowired
    private RatingsService ratingsService;

    @GetMapping("/movieRatings/{movieId}")
    public Mono<Ratings> getMovieRating(@PathVariable int movieId){
        return ratingsService.getRatingsByMovieId(movieId);
    }
}
