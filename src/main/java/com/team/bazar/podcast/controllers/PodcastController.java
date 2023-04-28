package com.team.bazar.podcast.controllers;

import com.team.bazar.category.Category;
import com.team.bazar.category.CategoryService;
import com.team.bazar.podcast.dto.PodcastDTO;
import com.team.bazar.podcast.entities.Podcast;
import com.team.bazar.podcast.service.PodcastService;
import com.team.bazar.members.servicies.AuthorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("api/podcast")
public class PodcastController {

    private final ModelMapper modelMapper;


    private final PodcastService podcastService;

    private final CategoryService categoryService;

    private final AuthorService authorService;


    private final HttpServletRequest httpServlet;

    @Autowired
    public PodcastController(ModelMapper modelMapper, PodcastService podcastService, CategoryService categoryService, AuthorService authorService, HttpServletRequest httpServlet) {
        this.modelMapper = modelMapper;
        this.podcastService = podcastService;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.httpServlet = httpServlet;
    }

    @GetMapping("/show")
    public Iterable<Podcast> showPodcasts(){
        HttpSession httpSession = httpServlet.getSession();
        Integer count = (Integer) httpSession.getAttribute("count");

        if(count == null)
            httpSession.setAttribute("count", 1);
        else
            httpSession.setAttribute("count", count+1);
        System.out.println(count);
        return podcastService.findAll();
    }

    @GetMapping("/{podcastId}")
    public Optional<Podcast> getPodcastById(@PathVariable UUID podcastId){
        return podcastService.findById(podcastId);
    }

    @PostMapping("/new/{authorId}")
    public Podcast save(@RequestBody PodcastDTO podcastDTO, @PathVariable UUID authorId){


        Podcast podcast = new Podcast(LocalDate.now(),
                podcastDTO.getDescription(), podcastDTO.getTrackPath(), podcastDTO.getCoverPath()
                , (List<Category>) categoryService.findAllById(podcastDTO.getCategoryIds()));

        return podcastService.save(podcast, authorId);
    }

    @GetMapping("/{authorId}/podcasts")
    public Iterable<Podcast> getPodcastsByAuthorId(@PathVariable UUID authorId){
        return authorService.findAllPodcasts(authorId);

    }



}
