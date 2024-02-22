package com.practice.ratings.Service;

import com.practice.ratings.model.Ratings;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RatingsService {

    public Mono<Ratings> getRatingsByMovieId(int ratingNumber){
        Ratings ratings = new Ratings(ratingNumber, "dummySource");
        ratings.setRatingNumber(ratingNumber);
        return Mono.justOrEmpty(ratings);
    }
}
