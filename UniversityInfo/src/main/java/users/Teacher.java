package users;

import database_H2.AccessingDataJpaApplication;
import database_H2.Authentication;
import factoryuser.User;

import java.util.Scanner;

public class Teacher implements User {

    public static String getTextNameLesson() {
        return textNameLesson;
    }
    private static String textNameLesson;
    private static Integer index;

    public static Integer getIndex() {
        return index;
    }

    @Override
    public void infoStatus() {
        System.out.println("You work at the university");
    }

    @Override
    public void activitiesAtTheUniversity() {
        System.out.println("Write names of the lessons using Enter: ");
        System.out.println("Еo return to the menu, write back: ");
        while (true) {
            Scanner input = new Scanner(System.in);
            textNameLesson = input.nextLine();
            if (textNameLesson.equals("back"))
                break;
            AccessingDataJpaApplication.saveLesson();
        }
    }

    @Override
    public void getLesson() {
        System.out.println("Write index of lessons: ");
        Scanner input = new Scanner(System.in);
        index = input.nextInt();
        Authentication.authenticationGetById();
    }
    @Override
    public void getAllLessons() {
        Authentication.authenticationGetByAll();
    }
}