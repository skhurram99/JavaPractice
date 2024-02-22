package com.practice.ratings.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Ratings {

    int ratingNumber;
    String ratingSource;
}
