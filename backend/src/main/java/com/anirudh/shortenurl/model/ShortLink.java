package com.anirudh.shortenurl.model;

import jakarta.persistence.Entity;

@Entity
public class Links {
    private String userURL;
    private String shortenedURL;

}
