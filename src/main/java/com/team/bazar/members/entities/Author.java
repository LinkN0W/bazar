package com.team.bazar.members.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.bazar.podcast.entities.Podcast;
import com.team.bazar.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author implements Member{

    @Id
    @GeneratedValue
    private UUID id;

    private String description;

    @Column(name = "profile_photo_path")
    private String photo_path;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Podcast> podcasts;

    public Author(User user) {
    }
    public Author() {
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getPhoto() {
        return photo_path;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;

    }

    @Override
    public void setPhoto(String photo_path) {
        this.photo_path = photo_path;
    }


    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return this.user;
    }
}
