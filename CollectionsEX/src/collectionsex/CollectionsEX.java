
package collectionsex;

import CitiesAndCountries.City;
import CitiesAndCountries.CityDAO;
import CitiesAndCountries.Country;
import CitiesAndCountries.CountryDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class CollectionsEX {
    public static void main(String[] args) {
        
        CityDAO city_dataset = new CityDAO();
        String city_csv = "E:\\iti\\10 - JAVA _ UML\\03 - exercise\\CollectionsEX\\cities.csv";
        List<City> city_list = city_dataset.getData(city_csv);

        CountryDAO country_dataset = new CountryDAO();
        String country_csv = "E:\\iti\\10 - JAVA _ UML\\03 - exercise\\CollectionsEX\\countries.csv";
        List<Country> country_list = country_dataset.getData(country_csv);
        
        Map<String , List<City>> output = new HashMap<>();
        
        for (Country country : country_list) {
            String cc = country.getCountryCode();
            List<City> cities = new ArrayList<>();
            for (City city : city_list) {
                if(country.getCountryCode().equals(city.getCountryCode())){
                    cities.add(city);
                }
                else {
                    // do nothing
                }
            }
            
            // i multiplyed by -1 to sort cities in ascending order
            cities.sort((o1, o2) -> {return (o2.population - o1.population) * (-1); });
            output.put(cc, cities);
        }
        
        Iterator<City> x = output.get("IDN").iterator();
        while(x.hasNext()){
            City temp = x.next();
            System.out.println(temp.population + "\t\t" + temp.city_ascii);
        }
    }
}   
    

