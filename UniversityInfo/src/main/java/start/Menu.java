package start;

import exception.InputException;
import factoryuser.User;
import factoryuser.UserFactory;

import java.util.Scanner;

public class Menu {


    private static final User user;

    static {
        try {
            user = UserFactory.choicePerson();
        } catch (InputException e) {
            throw new RuntimeException(e);
        }
    }

    public static void choiceService() {
        if (UserFactory.getText().equals("Teacher")) {
            System.out.println("Menu choice service: info about status, write lessons, get lesson, get all lessons");
            Scanner input = new Scanner(System.in);
            String inp = input.nextLine();
            switch (inp) {
                case "info about status":
                    user.infoStatus();
                    break;
                case "write lessons":
                    user.activitiesAtTheUniversity();
                    Menu.choiceService();
                    break;
                case "get lesson":
                    user.getLesson();
                    break;
                case "get all lessons":
                    user.getAllLessons();
                    break;
            }
        }
        if (UserFactory.getText().equals("Student")) {
            System.out.println("Menu choice service: info about status, average point");
            Scanner input = new Scanner(System.in);
            String inp = input.nextLine();
            switch (inp) {
                case "info about status":
                    user.infoStatus();
                    break;
                case "average point":
                    user.activitiesAtTheUniversity();
                    break;
            }
        }
        if (UserFactory.getText().equals("Entrant")) {
            System.out.println("Menu choice service: info about status");
            Scanner input = new Scanner(System.in);
            String inp = input.nextLine();
            if ("info about status".equals(inp)) {
                user.infoStatus();
            }
        }
    }
}
