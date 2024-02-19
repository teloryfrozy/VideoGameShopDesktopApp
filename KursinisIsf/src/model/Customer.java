package model;

import java.time.LocalDate;

public class Customer extends User{
    private String cardNo;
    private String deliveryAddress;
    private String billingAddress;
    private LocalDate birthDate;

    public Customer(String name, String surname, String login, String password, String cardNo, String deliveryAddress, String billingAddress, LocalDate birthDate) {
        super(name, surname, login, password);
        this.cardNo = cardNo;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.birthDate = birthDate;
    }

    @Override
    public void greet2() {

    }
}
