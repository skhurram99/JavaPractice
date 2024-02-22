package com.example.reactiveWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/demo")
    public Mono<String> getMessage() {
        Mono<String> messageFromSource = getMessageFromSource();
        Mono<String> dataFromOtherSource = getDataFromOtherSource();
        return Mono.zip(messageFromSource, dataFromOtherSource)
                .map(objects -> objects.getT1() + objects.getT2());
    }

    private Mono<String> getMessageFromSource() {
        return Mono.just("Message from primary source ");
    }

    private Mono<String> getDataFromOtherSource() {

        WebClient.Builder builder = WebClient.builder();
        Mono<String> dataFromAnotherSource = builder.build()
                .get()
                .uri("http://localhost:8082/anotherPath")
                .retrieve()
                .bodyToMono(String.class);


        return dataFromAnotherSource;
    }

}
