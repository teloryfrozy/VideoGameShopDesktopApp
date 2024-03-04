package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Comment {
    private int id;
    private String commentTitle;
    private LocalDate createdDate;
    private String commentDescription;
    private LocalDate modifiedDate;
    private User owner;
    private List<Comment> replies;
    private float rating;
}
