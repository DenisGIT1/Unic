package app.sorting;

import app.entity.Cities;
import app.fileSource.DirectoryOfCities;
import java.util.*;
import java.util.stream.Collectors;

public class CityCounter {

    public static void counterCityOfRegion() {
        List<Cities> allCity = DirectoryOfCities.sberListOfCities();
        List<Cities> regionnameList = allCity.stream().distinct().collect(Collectors.toList());
        Map<String, Integer> mapCityRegions = CityCounter.mapCity(allCity, regionnameList);
        mapCityRegions.forEach((k, v) -> System.out.println("* " + k + " - " + v));
    }

    public static Map<String, Integer> mapCity(List<Cities> allCity, List<Cities> regionnameList){
        Map<String, Integer> countersMap = new HashMap();
        for (int i = 0; i < regionnameList.size(); i++) {
            Cities citiesCounter = regionnameList.get(i);
            String regionName = citiesCounter.getRegion();
            List<Integer> integerList = new ArrayList<>();
            for (int j = 0; j < allCity.size(); j++) {
                Cities cityExAllCity = allCity.get(j);
                if (regionName.equals(cityExAllCity.getRegion())) {
                    integerList.add(1);
                }
            }
            countersMap.put(regionName, integerList.size());
        }
        return countersMap;
    }
}