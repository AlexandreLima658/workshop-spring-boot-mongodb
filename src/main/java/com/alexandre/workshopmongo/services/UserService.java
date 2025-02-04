package com.alexandre.workshopmongo.services;


import com.alexandre.workshopmongo.domain.User;
import com.alexandre.workshopmongo.dto.UserDTO;
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

    public void delete(final String id) {
        final var user =  findById(id);
        this.repository.deleteById(user.getId());
    }

    public User update(final User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return repository.save(newUser);

    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(final UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail()
        );
    }
}
