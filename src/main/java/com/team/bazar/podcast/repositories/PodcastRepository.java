package com.team.bazar.podcast.repositories;

import com.team.bazar.podcast.entities.Podcast;
import com.team.bazar.members.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PodcastRepository extends CrudRepository<Podcast, UUID> {


    Iterable<Podcast> findByAuthor(Author author);
}
