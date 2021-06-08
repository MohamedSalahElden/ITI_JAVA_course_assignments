
package lab_exercise_3;

import CitiesAndCountries.City;
import CitiesAndCountries.CityDAO;
import CitiesAndCountries.Country;
import CitiesAndCountries.CountryDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab_Exercise_3 {
    public static void main(String[] args) {
  
        CityDAO city_dataset = new CityDAO();
        String city_csv = "E:\\iti\\10 - JAVA _ UML\\03 - exercise\\CollectionsEX\\cities.csv";
        List<City> city_list = city_dataset.getData(city_csv);

        CountryDAO country_dataset = new CountryDAO();
        String country_csv = "E:\\iti\\10 - JAVA _ UML\\03 - exercise\\CollectionsEX\\countries.csv";
        List<Country> country_list = country_dataset.getData(country_csv);
        
        List<City> HPS = new ArrayList<>();
        
        Map<String , List<City>> g;
        g = city_list.stream().collect(Collectors.groupingBy((a) -> a.getCountryCode()));
//        System.out.println(g.keySet());
        g.keySet().forEach(t -> HPS.add(g.get(t).stream().max((o1 , o2)->o1.population - o2.population).get()) );
        HPS.forEach(t -> System.out.println(t.getCountryCode() + "\t\t" + t.population + "\t\t" + t.city_ascii));
        
        /////////////////// Highest population capital //////////////
        
//    city_list.stream().filter(t -> t.isCapital()).forEach((t) -> System.err.println(t.isCapital() + "\t\t"+t.city_ascii));
        City maxCapital = city_list.stream().filter(t -> t.isCapital()).max((o1, o2) -> o1.population - o2.population).get();
        System.out.println("max capital city in population is " + maxCapital.city_ascii + " with population = " + maxCapital.population);
        
        
        

    }
}
