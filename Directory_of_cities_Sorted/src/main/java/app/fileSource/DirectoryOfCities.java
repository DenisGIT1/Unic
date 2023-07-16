package app.fileSource;

import app.entity.Cities;

import java.util.ArrayList;
import java.util.List;

public class DirectoryOfCities {

    public List<Cities> objectConverter(List<String[]> arrays) {
        List<Cities> citiesList = new ArrayList<>();
        List<String[]> abc = arrays;
        for (int i = 0; i < arrays.size(); i++) {
            String[] str = arrays.get(i);
            for (int j = 0; j < str.length; j++) {
                if (str.length == 6) {
                    String name = str[1];
                    String region = str[2];
                    String district = str[3];
                    String population = str[4];
                    String foundation = str[5];
                    Cities cities = new Cities(name, region, district, population, foundation);
                    citiesList.add(cities);
                    break;
                } else if (str.length == 5) {
                    String name = str[1];
                    String region = str[2];
                    String district = str[3];
                    String population = str[4];
                    String foundation = null;
                    Cities cities = new Cities(name, region, district, population, foundation);
                    citiesList.add(cities);
                    break;
                }
            }
        }
        return citiesList;
    }

    public static void printCities(List<Cities> list) {
        List<Cities> xx = list;
        for (int i = 0; i < list.size(); i++) {
            Cities obj = list.get(i);
            System.out.println(obj);
            System.out.println();
        }
    }

    public static List<Cities> sberListOfCities() {
        JavaFileScanner object = new JavaFileScanner();
        Integer length = object.rowCounter();
        String[] arr = object.stringArrayConverter(length);
        List<String[]> listarr = object.converterToListOfArraysOfStrings(arr, length);
        DirectoryOfCities directory = new DirectoryOfCities();
        List<Cities> city = directory.objectConverter(listarr);
        return city;
    }

    public static void sberCitiesPrint() {
        DirectoryOfCities.printCities(DirectoryOfCities.sberListOfCities());
    }
}