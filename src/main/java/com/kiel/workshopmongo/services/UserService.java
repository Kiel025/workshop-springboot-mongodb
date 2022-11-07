package com.kiel.workshopmongo.services;

import com.kiel.workshopmongo.domain.User;
import com.kiel.workshopmongo.dto.UserDTO;
import com.kiel.workshopmongo.repositories.UserRepository;
import com.kiel.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.jetbrains.annotations.NotNull;
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

    public User insert(User user) {
        return repository.insert(user);
    }

    public User update(String id, User user) {
        User newUser = findById(id);
        updateData(user, newUser);
        return repository.save(newUser);
    }

    private void updateData(@NotNull User user, @NotNull User newUser) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(@NotNull UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
