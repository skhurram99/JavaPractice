package com.practice.movie.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class LoadBalancedConfiguration {

    @LoadBalanced
    //@Bean
    public WebClient.Builder webclientBuilder(){
        return WebClient.builder();
    }
}
