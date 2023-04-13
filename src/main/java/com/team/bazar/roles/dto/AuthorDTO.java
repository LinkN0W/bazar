package com.team.bazar.roles.dto;

import com.team.bazar.podcast.entities.Podcast;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

public class AuthorDTO {

    private String title;


    private Iterable<UUID> podcastsIds;

}
