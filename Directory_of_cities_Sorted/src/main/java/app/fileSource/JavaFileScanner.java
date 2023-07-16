package app.fileSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaFileScanner {

    public Integer rowCounter() {
        Scanner scanner = null;
        List<String> rowsList = new ArrayList<>();
        try {
            scanner = new Scanner(new FileReader(new File("D:\\program\\Задача ВС Java Сбер.csv")));
            scanner.useDelimiter(System.getProperty("line.separator"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String row = scanner.next();
            rowsList.add(row);
        }
        scanner.close();
        return rowsList.size();
    }

    public String[] stringArrayConverter(Integer quantityRows) {
        String[] stringArray = new String[quantityRows];
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(new File("D:\\program\\Задача ВС Java Сбер.csv")));
            scanner.useDelimiter(System.getProperty("line.separator"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            for (int i = 0; i < quantityRows; i++) {
                String word = scanner.next();
                stringArray[i] = word;
            }
        }
        scanner.close();
        return stringArray;
    }

    public List<String[]> converterToListOfArraysOfStrings(String[] array, Integer quantityRows) {
        List<String[]> listOfArrays = new ArrayList<>();
        for (int i = 0; i < quantityRows; i++) {
            String str = array[i];
            String[] parts = str.split(";");
            listOfArrays.add(parts);
        }
        return listOfArrays;
    }
}