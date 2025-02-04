package com.alexandre.workshopmongo.resources;


import com.alexandre.workshopmongo.domain.User;
import com.alexandre.workshopmongo.dto.UserDTO;
import com.alexandre.workshopmongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController implements UserAPI {

    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<Void> insert(final UserDTO user) {

        User obj = service.fromDTO(user);
        obj = service.persist(obj);

        final var uri = "/users/" + obj.getId();
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @Override
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> list = service.findAll();

        List<UserDTO> listDTO = list
                .stream()
                .map(UserDTO::new)
                .toList();

        return ResponseEntity.ok().body(listDTO);

    }

    @Override
    public ResponseEntity<UserDTO> findById(final String userId) {
        User user = service.findById(userId);
        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok().body(userDTO);
    }

    @Override
    public void delete(final String userId) {
        this.service.delete(userId);
    }

    @Override
    public void update(final UserDTO userDTO, final String userId) {

        User user = service.fromDTO(userDTO);
        user.setId(userId);

        this.service.update(user);
    }
}
