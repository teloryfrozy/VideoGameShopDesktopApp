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
    private String color;
    private float price;
    private String size;

    public Console(String title, String description, float price, String color, String size) {
        super(null, 0, description, title, price);
        this.color = color;
        this.size = size;
    }

    @Override
    public String getProductType() {
        return "Console";
    }
}
