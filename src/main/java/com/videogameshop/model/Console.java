package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Console extends Product {
    private String title;
    private String description;
    private String size;
    private float ranking;
    private String color;


    public Console(String title, String description, String color, float price, String size) {
        // TODO: handle auto increment of id with database
        super(null, 0, description, title, price);
        this.color = color;
        this.size = size;
    }
    @Override
    public String getProductType() {
        return "Console";
    }
}
