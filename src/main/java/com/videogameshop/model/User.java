package com.videogameshop.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
public abstract class User implements Serializable {
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
