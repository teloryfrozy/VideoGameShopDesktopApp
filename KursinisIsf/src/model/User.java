package model;

import java.time.LocalDate;

public abstract class User {
    //Man reikes veliau, kai dirbsiu su db
    protected int id;
    protected String name;
    protected String surname;
    protected String login;
    protected String password;
    protected LocalDate dateCreated;
    protected LocalDate dateModified;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.dateCreated = LocalDate.now();
    }

    public abstract void greet2();

    public void greet() {
        System.out.println("Hi there" + name + " " + surname);
    }

    public void greet(String text) {
        System.out.println("Hi there" + name + " " + surname);
    }
}
