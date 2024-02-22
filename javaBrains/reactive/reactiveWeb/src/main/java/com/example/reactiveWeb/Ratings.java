package com.example.reactiveWeb;

public class Ratings {
    int ratingNumber;

    public Ratings() {
    }

    public Ratings(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "ratingNumber=" + ratingNumber +
                '}';
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }
}
