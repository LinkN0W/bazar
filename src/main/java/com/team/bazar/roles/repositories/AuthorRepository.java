package com.team.bazar.roles.repositories;

import com.team.bazar.podcast.entities.Podcast;
import com.team.bazar.roles.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuthorRepository extends CrudRepository<Author, UUID> {



}
