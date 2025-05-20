package com.alexandre.workshopmongo.repository;


import com.alexandre.workshopmongo.domain.Post;
import com.alexandre.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
