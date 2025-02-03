package com.alexandre.workshopmongo.config;

import com.alexandre.workshopmongo.domain.User;
import com.alexandre.workshopmongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository repository;

    public Instantiation(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        User maria = new User(null, "Maria", "maria@email.com");
        User alex = new User(null, "Alex", "alex@email.com");
        User pedro = new User(null, "Pedro", "pedro@email.com");
        User alexandre = new User(null, "Alexandre", "alexandre@gmail.com");
        User liana = new User(null, "Liana", "lia@gmail.com");

        repository.saveAll(Arrays.asList(maria, alex, pedro, alexandre, liana));
    }
}
