package com.team.bazar.podcast.service;

import com.team.bazar.podcast.entities.Podcast;
import com.team.bazar.podcast.repositories.PodcastRepository;
import com.team.bazar.members.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PodcastService {

    private final PodcastRepository podcastRepository;

    private final AuthorRepository authorRepository;

    @Autowired
    public PodcastService(PodcastRepository podcastRepository, AuthorRepository authorRepository) {
        this.podcastRepository = podcastRepository;
        this.authorRepository = authorRepository;
    }

    public Iterable<Podcast> findAll() {return this.podcastRepository.findAll();}


    public Podcast save(Podcast podcast, UUID authorId){
        podcast.setAuthor(authorRepository.findById(authorId).get());
        return this.podcastRepository.save(podcast);
    }


    public Optional<Podcast> findById(UUID id){
        return this.podcastRepository.findById(id);
    }


}
