package app;

import app.fileSource.DirectoryOfCities;
import app.sorting.CitiesComparators;


public class Main {
    public static void main(String[] args) {


        // Вывод в консоль город из справочника
        DirectoryOfCities.sberCitiesPrint();


        // Сортировка городов по наименованию в алфавитном порядке без учета регистра
        CitiesComparators.sortingNamesOfCities();


        // Сортировка по федеральному округу и наименованию города
        CitiesComparators.sortingFederalDistrictOfCities();
    }
}