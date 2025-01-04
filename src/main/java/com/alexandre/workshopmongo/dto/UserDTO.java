package com.alexandre.workshopmongo.dto;

import com.alexandre.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
