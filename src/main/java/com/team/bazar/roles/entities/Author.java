package com.team.bazar.roles.entities;

import com.team.bazar.podcast.entities.Podcast;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    @OneToMany(mappedBy = "author")
    private List<Podcast> podcasts;

}
