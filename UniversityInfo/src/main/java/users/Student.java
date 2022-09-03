package users;

import factoryuser.User;

import java.util.Arrays;
import java.util.Scanner;

public class Student implements User {

    @Override
    public void infoStatus() {
        System.out.println("You learn at the university");
    }

    @Override
    public void activitiesAtTheUniversity() {
        System.out.println("Write you points in line using space: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        int[] array = Arrays.stream(text.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int average = (Arrays.stream(array)).sum() / array.length;
        System.out.println("average point = " + average);

    }

    @Override
    public void getLesson() {}

    @Override
    public void getAllLessons() {}
}
