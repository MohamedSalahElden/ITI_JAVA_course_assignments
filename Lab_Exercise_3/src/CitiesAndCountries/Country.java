
package CitiesAndCountries;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String iso3;
    private String country;

    public String getCountryCode() {
        return iso3;
    }

    public String getCountryName() {
        return country;
    }
    
    

    public Country(String iso3, String country) {
        this.iso3 = iso3;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" + "iso3=" + iso3 + ", country=" + country + '}';
    }
    
    

    
}
