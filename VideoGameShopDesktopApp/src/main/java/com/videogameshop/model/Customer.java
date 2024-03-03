package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Customer extends User {
    private String cardNo;
    private String deliveryAddress;
    private String billingAddress;
    private LocalDate birthDate;

    // Full constructor
    public Customer(String name, String surname, String login, String password, String cardNo, String deliveryAddress, String billingAddress, LocalDate birthDate) {
        super(name, surname, login, password);
        this.cardNo = cardNo;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.birthDate = birthDate;
    }

    // Constructor with minimal information
    public Customer(String name, String surname, String login, String password) {
        super(name, surname, login, password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
