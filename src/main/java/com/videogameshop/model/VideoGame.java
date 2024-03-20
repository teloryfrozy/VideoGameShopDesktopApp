package com.videogameshop.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VideoGame extends Product {
    private String title;
    private String description;
    private String pegi;
    private float ranking;

    public VideoGame(String title, String description, float price, String pegi) {
        super(null, 0, description, title, price);
        this.pegi = pegi;
    }

    @Override
    public String getProductType() {
        return "Video Game";
    }
}
