package com.javacourse.courseprojectfx.model;

public class Manager extends User{
    private boolean isAdmin;

    public Manager(String name, String surname, String login, String password, boolean isAdmin) {
        super(name, surname, login, password);
        this.isAdmin = isAdmin;
    }

    public Manager() {
    }

    @Override
    public void greetUser(String text) {
        System.out.println("Manager" + text);
    }

    @Override
    public void greet() {
        System.out.println("None");
    }
}
