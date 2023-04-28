package com.team.bazar.members.controllers;


import com.team.bazar.members.entities.Author;
import com.team.bazar.members.servicies.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        Author authors = authorService.save(author);
        return authors;
    }
}
