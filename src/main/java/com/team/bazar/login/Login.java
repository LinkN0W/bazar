package com.team.bazar.login;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "logins")
@Getter
@Setter
public class Login {

    public static enum UserRole {
        ADMIN, USER, AUTHOR;
        public static UserRole getById(String id){
            for(UserRole e : values()) {
                if(e.name().equalsIgnoreCase(id)) return e;
            }
            return USER;
        }

    }

    @Id
    @GeneratedValue()
    private UUID id;


    private String email;

    private String password;

    private UserRole role = UserRole.USER;

    private String login;


}
