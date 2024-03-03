package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public abstract class Product implements Serializable {
    protected List<Comment> comments;
    int id;
    private String description;
    private String title;
    private float price;

    public Product(List<Comment> comments, int id, String description, String title, float price) {
        this.comments = comments;
        this.id = id;
        this.description = description;
        this.title = title;
        this.price = price;
    }

    public void removeMessage() {
        System.out.println("\u001B[31m[Product] " + this.title + " has been removed");
    }
    public abstract String getProductType();
    @Override
    public String toString() {
        return String.format("[%s] Title: %s, Price: %.2f", getProductType(), title, price);
    }
}
