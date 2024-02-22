package com.practice.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Ratings {

    int ratingNumber;
    String ratingSource;
}
