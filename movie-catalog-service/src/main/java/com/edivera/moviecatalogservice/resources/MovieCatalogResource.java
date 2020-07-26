package com.edivera.moviecatalogservice.resources;

import com.edivera.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController     // marks the class as request handler
@RequestMapping("/catalog") // mapping for any request. could have been added inside as well
//@GetMapping   // mapping for the get method
public class MovieCatalogResource {

    @RequestMapping("/{userId}")    // variable userId
    // could have also been @RequestMapping("/catalog/{userId}").
    // it is implicitly @RequestMapping("/catalog/{userId}") as a result of the mapping outside the class
    public List<CatalogItem> getCalaog(@PathVariable("userId") String userId) {
        // maps /catalog/{userId} to this function. all well. part of most backends

        return Collections.singletonList(
                new CatalogItem("Transformers", "Test", 4)
        );
    }
}
