package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoGame extends Product {
    private String title;
    private String description;
    private String pegi;
    private int id;
    private float ranking;

    // Constructor with all the fields
    public VideoGame(String title, String description, float price, String pegi) {
        super(null, 0, description, title, price);
        this.pegi = pegi;
    }
}
