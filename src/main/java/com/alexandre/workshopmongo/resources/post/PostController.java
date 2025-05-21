package com.alexandre.workshopmongo.resources.post;

import com.alexandre.workshopmongo.domain.Post;
import com.alexandre.workshopmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController implements PostAPI{

    private final PostService postService;

    public PostController(final PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<Post> findById(final String postId) {
        Post post = postService.findById(postId);

        return ResponseEntity.ok().body(post);
    }
}
