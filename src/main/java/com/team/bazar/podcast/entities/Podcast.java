package com.team.bazar.podcast.entities;

import com.team.bazar.category.Category;
import com.team.bazar.members.entities.Author;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "podcasts")
@Getter
@Setter
public class Podcast {

    @Id
    @GeneratedValue()
    private UUID id;

//    @Column(name = "date_load")
//    private LocalDate dateLoad;

    @Column(name = "description")
    private String description;

    @Column(name = "track_path")
    private String trackPath;

    @Column(name = "cover_path")
    private String coverPath;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @Cascade({org.hibernate.annotations.CascadeType.REMOVE,
            org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Author author;



    @ManyToMany
    @JoinTable(name = "podcasts_categories",
            joinColumns = @JoinColumn(name = "podcast_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))

    private List<Category> categories;


    //TODO to realize ManyToMany connection Category_id with id 0f Category
    //TODO add to constructor Iterable<UUID>
    public Podcast(LocalDate dateLoad, String description,
                   String trackPath, String coverPath, List<Category> categories) {
        //this.dateLoad = dateLoad;
        this.description = description;
        this.trackPath = trackPath;
        this.coverPath = coverPath;
        this.categories = categories;
    }

    public Podcast() {

    }



}
