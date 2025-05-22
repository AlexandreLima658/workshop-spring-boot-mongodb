package com.alexandre.workshopmongo.dto;

import java.util.Date;

public class CommentDTO {

    private String text;
    private Date date;
    private AuthorDTO author;

    public CommentDTO(){}
    public CommentDTO(
            final String text,
            final Date date,
            final AuthorDTO author
    ){
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText(){
        return text;
    }
    public Date getDate(){
        return date;
    }
    public AuthorDTO getAuthor(){
        return author;
    }

}
