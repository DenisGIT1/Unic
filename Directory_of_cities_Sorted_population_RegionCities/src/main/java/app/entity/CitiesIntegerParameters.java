package app.entity;

public class CitiesIntegerParameters {
    private Integer id;
    private String name;
    private String region;
    private String district;
    private Integer population;
    private String foundation;


    public CitiesIntegerParameters(Integer id, String name, String region, String district, Integer population, String foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }


    @Override
    public String toString() {
        return "[" + id + "]" + " = " + CitiesIntegerParameters.stringPopulation(population);
    }

    public static String stringPopulation(Integer population) {
        StringBuilder splitCityPopulation = new StringBuilder(Integer. toString(population));
        splitCityPopulation.reverse();
        splitCityPopulation.insert(3, " ");
        splitCityPopulation.insert(7, " ");
        splitCityPopulation.reverse();
        String strPopulation = String.valueOf(splitCityPopulation);
        return strPopulation;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }
}
