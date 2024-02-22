package com.example.reactiveWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MovieController {

    @GetMapping("/movie")
    public Flux<Movie> getMovie() {

        WebClient.Builder builder = WebClient.builder();
        return builder.build()
                .get()
                .uri("http://localhost:8087/movie")
                .retrieve()
                .bodyToFlux(Movie.class);
    }

}
