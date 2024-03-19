package com.videogameshop.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Accessory extends Product {
    private String title;
    private String description;
    private int quantity;
    private List<Comment> reviews;
    private float ranking;
    private String color;

    public Accessory(String title, String description, float price, int quantity, String color) {
        super(null, 0, description, title, price);
        this.quantity = quantity;
        this.color = color;
    }

    @Override
    public String getProductType() {
        return "Accessory";
    }
}
