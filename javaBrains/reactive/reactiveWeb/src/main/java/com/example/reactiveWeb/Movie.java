package com.example.reactiveWeb;

public class Movie {
    String name;

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, String launchYear, Ratings ratings) {
        this.name = name;
        this.launchYear = launchYear;
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", launchYear='" + launchYear + '\'' +
                ", ratings=" + ratings +
                '}';
    }

    String launchYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    Ratings ratings;
}
