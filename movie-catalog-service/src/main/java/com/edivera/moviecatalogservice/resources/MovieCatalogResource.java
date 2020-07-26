package com.edivera.moviecatalogservice.resources;

import com.edivera.moviecatalogservice.models.CatalogItem;
import com.edivera.moviecatalogservice.models.Movie;
import com.edivera.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController     // marks the class as request handler
@RequestMapping("/catalog") // mapping for any request. could have been added inside as well
//@GetMapping   // mapping for the get method
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")    // variable userId
    // could have also been @RequestMapping("/catalog/{userId}").
    // it is implicitly @RequestMapping("/catalog/{userId}") as a result of the mapping outside the class
    public List<CatalogItem> getCalaog(@PathVariable("userId") String userId) {
        // maps /catalog/{userId} to this function. all well. part of most backends

        // changed rest template into a bean, how is this any different than a protected static??
        //RestTemplate restTemplate = new RestTemplate(); // creates a call to another microservice
        // makes a rest call to any URL and gets back a json string response.
        // if you know what the payload is on its return, pass it, it creates an object and
        // populates the fields and returns that object.
        // it's also a GET http method caller.



        // get all rated movie IDs
        /*// the hardcoded way
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );
        */

        Rating[] ratingsArr = restTemplate.getForObject("http://localhost:8083/ratingsdata/"
                + userId, Rating[].class);

        List<Rating> ratings = Arrays.asList(ratingsArr);

        return ratings.stream().map(rating -> {
            // For each movie ID, call movie info service and get details
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"
                            + rating.getMovieId(), Movie.class);

            // put them all together
            return new CatalogItem(movie.getName(), "Test", rating.getRating());
        }).collect(Collectors.toList());

        // previous hardcorded catalogitem list
//        return Collections.singletonList(
//                new CatalogItem("Transformers", "Test", 4)
//        );
    }
}
