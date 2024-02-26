package utils;

import model.Manager;
import model.User;

import java.util.List;
import java.util.Scanner;

public class MenuGenerator {
    public static void generateUserMenu(Scanner scanner, List<User> systemUsers) {
        var userMenuCmd = 0;

        while (userMenuCmd != 6) {
            System.out.println("""
                    --------------------
                    Choose an action:
                    1 - create User
                    2 - view all users
                    3 - update user
                    4 - delete user
                    5 - view specific user
                    6 - quit
                    --------------------""");

            userMenuCmd = scanner.nextInt();
            scanner.nextLine();

            switch (userMenuCmd){
                case 1:
                    System.out.println("Which type of user? C/M");
                    var response = "";
                    response = scanner.nextLine();
                    if(response.equals("C")){

                    } else if (response.equals("M")) {
                        System.out.println("Enter manager data: name;surname;login;psw;isAdmin;");
                        response = scanner.nextLine();
                        String[] info = response.split(";");
                        Manager manager = new Manager(info[0], info[1], info[2], info[3], Boolean.parseBoolean(info[4]));
                        systemUsers.add(manager);
                        System.out.println(manager);
                    } else {
                        System.out.println("Wrong user type\n");
                    }
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }
}
