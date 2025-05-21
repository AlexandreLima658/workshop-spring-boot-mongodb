package com.alexandre.workshopmongo.services;


import com.alexandre.workshopmongo.domain.Post;
import com.alexandre.workshopmongo.exception.NotFoundException;
import com.alexandre.workshopmongo.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(final String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Post não encontrado"));
    }
}
