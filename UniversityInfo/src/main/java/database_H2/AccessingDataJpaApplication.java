package database_H2;

import start.Registration;
import users.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
public class AccessingDataJpaApplication {
    static ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);
    static LessonRepository repository = context.getBean(LessonRepository.class);

    public static void saveLesson() {
        repository.save(new Lesson(Registration.getLogin(),Teacher.getTextNameLesson()));
    }

    public static void getLessonById() {
        System.out.println(repository.findById(Teacher.getIndex()));
        context.close();
    }

    public static void getLessonByAll() {
        for (Lesson lesson : repository.findAll()) {
            System.out.println(lesson.toString());
            context.close();
        }
    }
}