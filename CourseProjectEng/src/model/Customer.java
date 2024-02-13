package model;

public class Customer extends User{
    private String cardNo;

    public Customer(String name, String surname, String login, String password, String cardNo) {
        super(name, surname, login, password);
        this.cardNo = cardNo;
    }

    @Override
    public void greetUser(String text) {

    }
}
