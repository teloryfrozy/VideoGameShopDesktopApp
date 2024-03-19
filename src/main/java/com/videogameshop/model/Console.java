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
public class Console extends Product {
    private String title;
    private String description;
    private String size;
    private float ranking;
    private String color;


    @Override
    public String getProductType() {
        return "Console";
    }
}
