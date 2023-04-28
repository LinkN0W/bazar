package com.team.bazar.members.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")

public class User  {


    public static enum UserRole {
        ADMIN, USER, AUTHOR;
        public static User.UserRole getById(String id){
            for(User.UserRole e : values()) {
                if(e.name().equalsIgnoreCase(id)) return e;
            }
            return USER;
        }

    }
    @Id
    @GeneratedValue
    private UUID id;

    private String email;

    private String login;

    private String password;

    private UserRole role = UserRole.USER;



}
