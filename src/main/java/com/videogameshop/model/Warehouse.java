package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Warehouse {
    private int id;
    private String address;
    private List<Product> productList;
    private List<Manager> employees;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}