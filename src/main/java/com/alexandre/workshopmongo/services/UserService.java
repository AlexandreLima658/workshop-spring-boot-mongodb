package com.alexandre.workshopmongo.services;


import com.alexandre.workshopmongo.domain.User;
import com.alexandre.workshopmongo.exception.NotFoundException;
import com.alexandre.workshopmongo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(final String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public User persist(final User user){
        return repository.insert(user);
    }
}
