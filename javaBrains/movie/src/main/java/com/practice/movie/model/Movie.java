package com.practice.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Movie {

public String movieName;
public int movieId;
public Ratings ratings;
}
