package com.alexandre.workshopmongo.resources;


import com.alexandre.workshopmongo.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "users")
@Tag(name = "Usuários")
public interface UserAPI {

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Criar um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "A validação falhou"),
            @ApiResponse(responseCode = "500", description = "Erro interno servidor")
    })
    ResponseEntity<Void> insert(@RequestBody UserDTO user);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Recuperar uma lista de usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuários recuperados com sucesso"),
            @ApiResponse(responseCode = "422", description = "A validação falhou"),
            @ApiResponse(responseCode = "500", description = "Erro interno servidor")
    })
    ResponseEntity<List<UserDTO>> findAll();

    @GetMapping( value = "/{userId}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Recuperar um usuário pelo seu identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário recuperado com sucesso"),
            @ApiResponse(responseCode = "422", description = "A validação falhou"),
            @ApiResponse(responseCode = "500", description = "Erro interno servidor")
    })
    ResponseEntity<UserDTO> findById(@PathVariable String userId);

    @DeleteMapping( value = "/{userId}")
    @Operation(summary = "Remover um usuário pelo seu identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário removido com sucesso"),
            @ApiResponse(responseCode = "422", description = "A validação falhou"),
            @ApiResponse(responseCode = "500", description = "Erro interno servidor")
    })
    void delete(@PathVariable String userId);

    @PutMapping( value = "/{userId}")
    @Operation(summary = "Atualizar um usuário pelo seu identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "A validação falhou"),
            @ApiResponse(responseCode = "500", description = "Erro interno servidor")
    })
    void update(@RequestBody UserDTO userDTO, @PathVariable String userId);




}
