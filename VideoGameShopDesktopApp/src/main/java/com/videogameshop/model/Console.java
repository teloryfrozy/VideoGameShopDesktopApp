package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Console extends Product {
    private String title;
    private String color;
    private String description;
    private String size;
    private float ranking;


    public Console(String title, String description, String color, float price, String size) {
        // TODO: handle auto increment of id with database
        super(null, 0, description, title, price);
        this.color = color;
        this.size = size;
    }
}
