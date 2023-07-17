package app.sorting;

import app.entity.Cities;
import app.fileSource.DirectoryOfCities;
import java.util.Comparator;
import java.util.List;

public class CitiesComparators {
    public static void sortingNamesOfCities() {
        List<Cities> allCity = DirectoryOfCities.sberListOfCities();
        allCity.sort((Cities city1, Cities city2) -> city1.getName().compareToIgnoreCase(city2.getName()));
        DirectoryOfCities.printCities(allCity);
    }
    public static void sortingFederalDistrictOfCities() {
        List<Cities> allCity = DirectoryOfCities.sberListOfCities();
        allCity.sort(Comparator.comparing(Cities::getDistrict).thenComparing(Cities::getName));
        DirectoryOfCities.printCities(allCity);
    }
}