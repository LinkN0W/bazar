package com.team.bazar.members.dto;

import java.util.UUID;

public class AuthorDTO {

    private UUID id;
    private String description;

    private String photo_path;

    private Iterable<UUID> podcastsIds;

}
