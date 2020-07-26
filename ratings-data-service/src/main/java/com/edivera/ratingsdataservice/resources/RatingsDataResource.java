package com.edivera.ratingsdataservice.resources;

import com.edivera.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

    /*
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
    */

    @RequestMapping("/{userId}")
    public Rating[] getRatings(@PathVariable("userId") String userId) {
        // hardcoded, but ideally requesting from a database
        ArrayList<Rating> ratings = new ArrayList<>();
        //Rating[] rats = new Rating[2];

        ratings.add(new Rating("9999", 4));
        //ratings[0] = new Rating("9999", 4);
        ratings.add(new Rating("5678", 3));
        //ratings[1] = new Rating("5678", 3);

        //return ratings;
        return ratings.toArray(new Rating[0]);  // convert list to array of type Rating[]
    }
}
