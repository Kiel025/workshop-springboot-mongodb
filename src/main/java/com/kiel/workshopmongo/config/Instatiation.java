package com.kiel.workshopmongo.config;

import com.kiel.workshopmongo.domain.Post;
import com.kiel.workshopmongo.domain.User;
import com.kiel.workshopmongo.dto.AuthorDTO;
import com.kiel.workshopmongo.dto.CommentDTO;
import com.kiel.workshopmongo.repositories.PostRepository;
import com.kiel.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instatiation implements CommandLineRunner {

    private static final DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018", fmt), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018", fmt), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", LocalDate.parse("21/03/2018", fmt), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!", LocalDate.parse("22/03/2018", fmt), new AuthorDTO(bob));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));

        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.parse("23/03/2018", fmt), new AuthorDTO(alex));

        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
