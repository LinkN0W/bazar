package com.team.bazar.members.repositories;

import com.team.bazar.members.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends CrudRepository<Author, UUID> {



}
