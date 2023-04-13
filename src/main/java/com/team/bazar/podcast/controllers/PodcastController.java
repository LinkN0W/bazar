package com.team.bazar.podcast.controllers;

import com.team.bazar.category.Category;
import com.team.bazar.category.CategoryService;
import com.team.bazar.podcast.dto.PodcastDTO;
import com.team.bazar.podcast.entities.Podcast;
import com.team.bazar.podcast.service.PodcastService;
import com.team.bazar.roles.servicies.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/podcast")
public class PodcastController {

    private final ModelMapper modelMapper;


    private final PodcastService podcastService;

    private final CategoryService categoryService;

    private final AuthorService authorService;

    @Autowired
    public PodcastController(ModelMapper modelMapper, PodcastService podcastService, CategoryService categoryService, AuthorService authorService) {
        this.modelMapper = modelMapper;
        this.podcastService = podcastService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping("/show")
    public Iterable<Podcast> showPodcasts(){
        return podcastService.findAll();
    }

    @GetMapping("/{podcastId}")
    public Optional<Podcast> getPodcastById(@PathVariable UUID podcastId){
        return podcastService.findById(podcastId);
    }

    @PostMapping("/new/{authorId}")
    public PodcastDTO save(@RequestBody PodcastDTO podcastDTO, @PathVariable UUID authorId){

        Podcast podcast = new Podcast(LocalDate.now(),
                podcastDTO.getDescription(), podcastDTO.getTrackPath(), podcastDTO.getCoverPath()
                , (List<Category>) categoryService.findAllById(podcastDTO.getCategoryIds()));

        podcastService.save(podcast, authorId);

        return podcastDTO;
    }

    @GetMapping("/{authorId}/podcasts")
    public List<PodcastDTO> getPodcastsByAuthorId(@PathVariable UUID authorId){

        return authorService.findAllPodcasts(authorId).stream()
                .map(podcast -> modelMapper.map(podcast, PodcastDTO.class))
                .collect(Collectors.toList());

    }





}
