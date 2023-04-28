package com.team.bazar.members.servicies;

import com.team.bazar.podcast.entities.Podcast;
import com.team.bazar.members.entities.Author;
import com.team.bazar.members.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public List<Podcast> findAllPodcasts(UUID authorId){
        return authorRepository.findById(authorId).get().getPodcasts();
    }
}
