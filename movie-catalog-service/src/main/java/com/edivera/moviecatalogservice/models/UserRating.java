package com.edivera.moviecatalogservice.models;

import java.util.List;

public class UserRating {
    private List<Rating> ratings;   // Rating also needs an empty constructor even inside list

    public UserRating() {
    }

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
