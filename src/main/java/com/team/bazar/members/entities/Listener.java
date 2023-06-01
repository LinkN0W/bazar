package com.team.bazar.members.entities;

import com.team.bazar.users.User;
import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.lang.NonNull;


import java.util.UUID;

@Entity
@Table(name = "listeners")
public class Listener  implements Member{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id ;

    @Column(name = "description")
    private String description;

    @Column(name = "profile_photo_path")
    private String photo_path;




    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Listener(User user) {
        this.user = user;
    }

    public Listener() {

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
