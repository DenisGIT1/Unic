package app.fileSource;

import app.entity.Cities;
import app.entity.CitiesIntegerParameters;
import java.util.ArrayList;
import java.util.List;

public class GenerateIntegerParameters {

    public static List<CitiesIntegerParameters> integerParametersConverter(List<Cities> list) {
        List<CitiesIntegerParameters> integerParametersList = new ArrayList<>();
        List<Cities> cities1 = list;
        for (int i = 0; i < cities1.size(); i++) {
            Cities objCity = cities1.get(i);
            Integer id = Integer.parseInt(objCity.getId());
                    String name = objCity.getName();
                    String region = objCity.getRegion();
                    String district = objCity.getDistrict();
                Integer population = Integer.parseInt(objCity.getPopulation());
            String foundation = objCity.getFoundation();
            CitiesIntegerParameters citiesIP = new CitiesIntegerParameters(id, name, region, district, population, foundation);
            integerParametersList.add(citiesIP);
            }
        return integerParametersList;
    }
}