package database_H2;

import start.Registration;

import java.util.Scanner;

public class Authentication {

    public static void authenticationGetById() {
        System.out.print("Write your password: ");
        Scanner input = new Scanner(System.in);
        int pass = input.nextInt();
        if (pass == Registration.getPassword()) {
            AccessingDataJpaApplication.getLessonById();
        }
        else System.out.println("Access denied");
        AccessingDataJpaApplication.context.close();
    }

    public static void authenticationGetByAll() {
        System.out.print("Write your password: ");
        Scanner input = new Scanner(System.in);
        int pass = input.nextInt();
        if (pass == Registration.getPassword()) {
            AccessingDataJpaApplication.getLessonByAll();
        }
        else System.out.println("Access denied");
        AccessingDataJpaApplication.context.close();
    }
}
