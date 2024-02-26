package model;

public final class Manager extends User {
    private boolean isAdmin;

    public Manager(String name, String surname, String login, String password, boolean isAdmin) {
        super(name, surname, login, password);
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "isAdmin=" + isAdmin +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public void greet2() {

    }

    @Override
    public void greet() {
        System.out.println("Hi manager " + login);
    }
}
