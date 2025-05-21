package com.alexandre.workshopmongo.config;

import com.alexandre.workshopmongo.domain.Post;
import com.alexandre.workshopmongo.domain.User;
import com.alexandre.workshopmongo.dto.AuthorDTO;
import com.alexandre.workshopmongo.repository.PostRepository;
import com.alexandre.workshopmongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;


@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository repository;
    private final PostRepository postRepository;

    public Instantiation(
            final UserRepository repository,
            final PostRepository postRepository
    ) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        repository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria", "maria@email.com");
        User alex = new User(null, "Alex", "alex@email.com");
        User pedro = new User(null, "Pedro", "pedro@email.com");
        User alexandre = new User(null, "Alexandre", "alexandre@gmail.com");
        User liana = new User(null, "Liana", "lia@gmail.com");

        repository.saveAll(Arrays.asList(maria, alex, pedro, alexandre, liana));

        Post post1 = new Post(null, date.parse("19/05/2021"), "My new Post", "This is my first post",new AuthorDTO(alexandre));
        Post post2 = new Post(null, date.parse("19/05/2021"), "My new Post", "This is my second post", new AuthorDTO(alexandre));
        Post post3 = new Post(null, date.parse("21/05/2025"), "This is my new post about today", "Welcome to my channel", new AuthorDTO(alex));


        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
