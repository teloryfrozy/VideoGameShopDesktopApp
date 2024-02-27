package com.javacourse.courseprojectfx.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tool extends Product {
    private String manufacturer;

    public Tool(String title, String description, int qty, float weight, String manufacturer) {
        super(title, description, qty, weight);
        this.manufacturer = manufacturer;
    }
}
