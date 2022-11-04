package com.kiel.workshopmongo.services;

import com.kiel.workshopmongo.domain.User;
import com.kiel.workshopmongo.repositories.UserRepository;
import com.kiel.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(
                () -> new ResourceNotFoundException(id)
        );
    }
}
