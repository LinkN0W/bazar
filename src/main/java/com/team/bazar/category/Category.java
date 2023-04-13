package com.team.bazar.category;

import com.team.bazar.podcast.entities.Podcast;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

//    @ManyToMany(mappedBy = "categories")
//    private List<Podcast> podcasts;




}
