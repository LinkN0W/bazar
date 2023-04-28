package com.team.bazar.members.entities;

public interface Member {

    String getDescription() ;

    String getPhoto() ;

    void setDescription(String description) ;

    void setPhoto(String photo_path) ;


    void setUser(User user);

    User getUser();

}
