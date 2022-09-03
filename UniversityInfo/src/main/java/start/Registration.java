package start;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Registration {
    private static Map<String, Integer> universityUsers = new HashMap<>();
    private static String login;

    public static String getLogin() {
        return login;
    }
    private static Integer password;

    public static Integer getPassword() {
        return password;
    }

    public static void registrationUser() {
        System.out.print("Write login consisting of letters: ");
        Scanner inputLogin = new Scanner(System.in);
        login = inputLogin.nextLine();
        System.out.print("Write password consisting of numbers: ");
        Scanner inputPassword = new Scanner(System.in);
        password = Integer.valueOf(inputPassword.nextLine());
        universityUsers.put(login, password);
    }
}