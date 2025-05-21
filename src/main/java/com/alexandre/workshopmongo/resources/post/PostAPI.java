package com.alexandre.workshopmongo.resources.post;


import com.alexandre.workshopmongo.domain.Post;
import com.alexandre.workshopmongo.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "posts")
@Tag(name = "Posts")
public interface PostAPI {

    @GetMapping( value = "/{postId}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Recuperar um post pelo seu identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post recuperado com sucesso"),
            @ApiResponse(responseCode = "422", description = "A validação falhou"),
            @ApiResponse(responseCode = "500", description = "Erro interno servidor")
    })
    ResponseEntity<Post> findById(@PathVariable String postId);

}
