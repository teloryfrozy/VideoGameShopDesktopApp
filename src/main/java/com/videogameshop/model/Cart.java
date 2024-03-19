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
public class Cart {
    @Id
    private int id;
    private List<Product> items;
    private Customer customer;
    private LocalDate dateCreated;
    private boolean isCheckout;
}