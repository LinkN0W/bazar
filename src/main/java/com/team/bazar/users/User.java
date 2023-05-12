package com.team.bazar.users;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


    private String name;

    private String password;

    @Builder.Default
    private UserRole role = UserRole.USER;


}
