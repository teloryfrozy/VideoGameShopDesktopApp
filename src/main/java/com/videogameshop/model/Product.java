package com.videogameshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public abstract class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String title;
    private String description;
    private float price;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    protected List<Comment> comments;

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
        return String.format("[%s]: %s, %.2f €", getProductType(), title, price);
    }
}
