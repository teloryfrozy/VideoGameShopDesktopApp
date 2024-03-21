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

    public Console(String title, String description, float price, String size, String color) {
        super(null, 0, description, title, price);
        this.size = size;
        this.color = color;
    }

    @Override
    public String getProductType() {
        return "Console";
    }
}
