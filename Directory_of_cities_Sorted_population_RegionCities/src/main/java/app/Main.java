package app;

import app.fileSource.DirectoryOfCities;
import app.sorting.CitiesComparators;
import app.sorting.CityCounter;
import app.sorting.CityResidents;

public class Main {

    public static void main(String[] args) {


        // Вывод в консоль город из справочника
        DirectoryOfCities.sberCitiesPrint();


        // Сортировка городов по наименованию в алфавитном порядке без учета регистра
        CitiesComparators.sortingNamesOfCities();


        // Сортировка по федеральному округу и наименованию города
        CitiesComparators.sortingFederalDistrictOfCities();


        // Вывод номера города (по справочнику) и количества населения (для города с самым большим населением)
        CityResidents.largestNumberOfCityResidents();

          // Поиск количества городов в разрезе регионов
        CityCounter.counterCityOfRegion();

    }
}