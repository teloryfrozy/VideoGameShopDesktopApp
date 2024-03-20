package com.videogameshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> productList;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Manager> managers;
    private String address;
    private LocalDate dateCreated;
    private LocalDate dateModified;


    public Warehouse(int id, String address, LocalDate dateCreated, LocalDate dateModified) {
        this.id = id;
        this.address = address;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }
}
