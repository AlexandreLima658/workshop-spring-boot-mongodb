package com.alexandre.workshopmongo.resources;


import com.alexandre.workshopmongo.domain.User;
import com.alexandre.workshopmongo.dto.UserDTO;
import com.alexandre.workshopmongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService service;

    public UserResource(final UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list
                .stream()
                .map(UserDTO::new)
                .toList();

        return ResponseEntity.ok().body(listDTO);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(
            @PathVariable String id
    ){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
