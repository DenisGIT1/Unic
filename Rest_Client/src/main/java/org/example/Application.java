package org.example;

import org.example.service.ChooseAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Override
    public void run(String... args) {
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


        ChooseAction.chooseAction();
    }
}