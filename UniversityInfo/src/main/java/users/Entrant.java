package users;

import factoryuser.User;

public class Entrant implements User {

    @Override
    public void infoStatus() {
        System.out.println("You go to university");
    }

    @Override
    public void activitiesAtTheUniversity() {
        System.out.println("No activity");
    }

    @Override
    public void getLesson() {}

    @Override
    public void getAllLessons() {}
}

