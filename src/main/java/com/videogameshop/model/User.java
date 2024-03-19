package com.videogameshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public abstract class User implements Serializable {
    @Id
    protected int id;
    protected String login;
    protected String password;
    protected String name;
    protected String surname;
    protected LocalDate dateCreated;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.dateCreated = LocalDate.now();
    }
}
