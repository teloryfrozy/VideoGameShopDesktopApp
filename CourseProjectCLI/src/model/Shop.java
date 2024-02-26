package model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<User> systemUsers;
    private List<Product> products;

    public Shop() {
        this.systemUsers = new ArrayList<>();
        this.products = new ArrayList<>();
    }
}
