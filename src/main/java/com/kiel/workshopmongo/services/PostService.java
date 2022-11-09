package com.kiel.workshopmongo.services;

import com.kiel.workshopmongo.domain.Post;
import com.kiel.workshopmongo.repositories.PostRepository;
import com.kiel.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(
                () -> new ResourceNotFoundException(id)
        );
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> findByBody(String text) {
        return repository.findByBodyContainingIgnoreCase(text);
    }
}
