package com.team.bazar.roles.controllers;


import com.team.bazar.podcast.dto.PodcastDTO;
import com.team.bazar.roles.entities.Author;
import com.team.bazar.roles.servicies.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/role")
public class RoleController {


    private final AuthorService authorService;

    @Autowired
    public RoleController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public Iterable<Author> getAllAuthors(){
        return authorService.findAll();
    }



    @PostMapping("/new")
    public Author save(@RequestBody Author author){
        System.out.println(author.getTitle());
        Author authors = authorService.save(author);

        return authors;
    }
}
