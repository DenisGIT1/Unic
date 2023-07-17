package app.sorting;

import app.entity.Cities;
import app.entity.CitiesIntegerParameters;
import app.fileSource.DirectoryOfCities;
import app.fileSource.GenerateIntegerParameters;

import java.util.Comparator;
import java.util.List;

public class CityResidents {
    public static void largestNumberOfCityResidents(){
        List<Cities> allCity = DirectoryOfCities.sberListOfCities();
        List<CitiesIntegerParameters> cityIPList = GenerateIntegerParameters.integerParametersConverter(allCity);
        cityIPList.sort(Comparator.comparingInt(CitiesIntegerParameters::getPopulation));
        CitiesIntegerParameters bigCityPopulation = cityIPList.get(cityIPList.size() - 1);
        System.out.println(bigCityPopulation.toString());
    }
}