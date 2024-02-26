import model.Customer;
import model.Manager;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer("a","a", "a", "a", "a", "a", "a", LocalDate.now());
        Manager manager = new Manager("b", "b", "b", "b", true);

        customer.greet();
        manager.greet();
    }
}
