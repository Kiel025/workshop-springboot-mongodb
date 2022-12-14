package com.kiel.workshopmongo.resources;

import com.kiel.workshopmongo.domain.Post;
import com.kiel.workshopmongo.resources.util.URL;
import com.kiel.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = service.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/bodysearch")
    public ResponseEntity<List<Post>> findByBody(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = service.findByBody(text);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "minDate", defaultValue = "") String textMinDate, @RequestParam(value = "maxDate", defaultValue = "") String textMaxDate) {
        text = URL.decodeParam(text);
        LocalDate minDate = URL.convertDate(textMinDate, LocalDate.of(1960, 1, 1));
        LocalDate maxDate = URL.convertDate(textMaxDate, LocalDate.now());
        List<Post> posts = service.fullSearch(text, minDate, maxDate);
        return ResponseEntity.ok().body(posts);
    }
}
