package database_H2;

import start.Registration;
import users.Teacher;

import javax.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column
    private String nameTeacher;
    @Column
    private String nameLesson;

    protected Lesson() {}

    public Lesson(String nameTeacher, String nameLesson) {
        this.nameTeacher = Registration.getLogin();
        this.nameLesson = Teacher.getTextNameLesson();
    }

    @Override
    public String toString() {
        return "Lesson{" + "id=" + id + ", nameTeacher='" + nameTeacher + '\'' +
                ", nameLesson='" + nameLesson + '\'' + '}';
    }
}