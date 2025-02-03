package com.alexandre.workshopmongo.resources;


import com.alexandre.workshopmongo.domain.User;
import com.alexandre.workshopmongo.dto.UserDTO;
import com.alexandre.workshopmongo.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
        User obj = service.fromDTO(objDTO);
        obj = service.persist(obj);

        final var uri = "/users/" + obj.getId();

        return ResponseEntity.created(URI.create(uri)).build();

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
        User user = service.fromDTO(userDTO);
        user.setId(id);
        service.update(user);
        return ResponseEntity.noContent().build();
    }
}
