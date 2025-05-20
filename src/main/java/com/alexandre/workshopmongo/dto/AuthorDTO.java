package com.alexandre.workshopmongo.dto;

import com.alexandre.workshopmongo.domain.User;

public class AuthorDTO{

    private String id;
    private String name;


    public AuthorDTO(){}

    public AuthorDTO(User obj) {
        id = obj.getId();
        name =  obj.getName();

    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

}
