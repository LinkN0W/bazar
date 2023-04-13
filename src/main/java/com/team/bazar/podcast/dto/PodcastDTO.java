package com.team.bazar.podcast.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PodcastDTO {


    private String description;


    private String trackPath;


    private String coverPath;

    private Iterable<UUID> categoryIds;


}
