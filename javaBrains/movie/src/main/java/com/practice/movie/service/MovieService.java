package com.practice.movie.service;

import com.practice.movie.model.Movie;
import com.practice.movie.model.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MovieService {


    //AnotherWay to get loadbalanced webclient builder
    @LoadBalanced
    public WebClient.Builder getWebClient(){
        return WebClient.builder();
    }

   /* @Autowired
    WebClient.Builder webclient;*/

    public Mono<Movie> getMovieRatingById(int movieId){
        Mono<Movie> movie = this.getWebClient().build()
                .get()
                .uri("http://localhost:8082/movieRatings/1")
                .retrieve()
                .bodyToMono(Ratings.class)
                .map(ratings1 -> new Movie("Rambo",1,ratings1));


        return movie;
    }
}
