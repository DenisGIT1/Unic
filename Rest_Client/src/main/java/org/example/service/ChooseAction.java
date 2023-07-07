package org.example.service;

import org.example.controller.Communication;
import org.example.entity.Human;
import java.util.Scanner;

public class ChooseAction {
    public static void chooseAction(){
        Communication com = new Communication();
        System.out.print("Choose number of option:" +
                "\n 1 - get All humans from database" +
                "\n 2 - get human by id" +
                "\n 3 - create new human" +
                "\n 4 - update human" +
                "\n 5 - delete human \n ");
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        switch (num){
            case "1":
               System.out.println(com.getAllHuman());
                break;
            case "2":
                System.out.println("Write id of human: ");
                String yyy = input.nextLine();
                Integer a = Integer.parseInt(yyy);
                System.out.println(com.getHuman(a));
                break;
            case "3":
                System.out.println("If you want create new human, write name: ");
                Scanner humName = new Scanner(System.in);
                String name = humName.nextLine();
                System.out.println("Write surname: ");
                Scanner humSurname = new Scanner(System.in);
                String surname = humName.nextLine();
                Human human = new Human(name, surname);
                com.saveHuman(human);
                break;
            case "4":
                System.out.println("If you want update human, write id: ");
                Scanner updateId = new Scanner(System.in);
                int identity = updateId.nextInt();
                System.out.println("Write name: ");
                Scanner updateName = new Scanner(System.in);
                String upName = updateName.nextLine();
                System.out.println("Write surname: ");
                Scanner updateSurname = new Scanner(System.in);
                String upSurname = updateSurname.nextLine();
                Human human1 = new Human(identity, upName, upSurname);
                com.saveHuman(human1);
                break;
            case "5":
                System.out.println("If you want delete human, write id: ");
                Scanner delId = new Scanner(System.in);
                int deleteId = delId.nextInt();
                com.deleteHuman(deleteId);
                break;
        }
    }
}