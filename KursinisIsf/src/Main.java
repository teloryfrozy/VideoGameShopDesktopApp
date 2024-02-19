import model.User;
import utils.MenuGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd = "";

        //Jei nuskaitau is failo ir viska ok --> uzkrauk


        List<User> systemUsers = new ArrayList<>();

        while (!cmd.equals("Q")) {
            System.out.println("""
                    --------------------
                    Choose an action:
                    U - work with users
                    P - work with products
                    Q - quit
                    --------------------""");

            cmd = scanner.nextLine();

            switch (cmd) {
                case "U":
                    MenuGenerator.generateUserMenu(scanner, systemUsers);
                    break;
                case "P":
                    //Kazka su produktais
                    break;
                case "Q":
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Learn to read\n");
            }


        }

    }
}