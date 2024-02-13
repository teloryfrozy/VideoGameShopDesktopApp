import model.Manager;
import model.User;

public class Main {
    public static void main(String[] args) {

        //All classes inherit from Object class
        Manager manager = new Manager("admin","admin","admin","admin", true);

        System.out.println(manager.getName());
        manager.greetUser("Hi");
    }
}