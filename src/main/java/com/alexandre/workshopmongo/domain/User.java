package com.alexandre.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;


@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    public User(){}

    public User(
            final String id,
            final String name,
            final String email
    ){
        super();
        this.id = id;
        this.name = name;
        this.email = email;

    }

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
