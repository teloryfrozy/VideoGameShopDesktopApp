package com.videogameshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Warehouse {
    @Id
    private int id;
    private String address;
    private LocalDate dateCreated;
    private LocalDate dateModified;

    private List<Product> productList;
    private List<Manager> managers;

    public Warehouse(int id, String address, LocalDate dateCreated, LocalDate dateModified) {
        this.id = id;
        this.address = address;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }
}
