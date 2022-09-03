package factoryuser;

import exception.InputException;
import users.Entrant;
import users.Student;
import users.Teacher;

import java.util.Scanner;

public class UserFactory {

    private static String text;

    public static String getText() {
        return text;
    }

    public static User choicePerson() throws InputException {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Write you status (Teacher, Student, Entrant): ");
        text = input.nextLine();
        return UserFactory.createUser(text);
    }

    public static User createUser(String typeOfUser) throws InputException {
        switch (typeOfUser) {
            case "Teacher": return new Teacher();
            case "Student": return new Student();
            case "Entrant": return new Entrant();
        }
        throw new InputException ("Unknown type");
    }
}