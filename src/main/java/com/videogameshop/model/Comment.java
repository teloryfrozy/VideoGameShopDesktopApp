package com.videogameshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    private int id;
    private String commentTitle;
    private LocalDate createdDate;
    private String commentDescription;
    private LocalDate modifiedDate;
    @ManyToOne
    private User owner;
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> replies;
    @ManyToOne
    private Comment parentComment;
    private float rating;
}
