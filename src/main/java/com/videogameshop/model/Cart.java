package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Cart {
    private int id;
    private List<Product> items;
    private Customer customer;
    private LocalDate dateCreated;
    private boolean isCheckout;
}
