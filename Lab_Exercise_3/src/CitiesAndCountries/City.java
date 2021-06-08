
package CitiesAndCountries;

public class City {
    private String iso3      ;
    public String city_ascii;
    private double lat       ;
    private double lng       ;
    private boolean capital  ;
    public int population;
    private String id        ;

    public City(String iso3, String city_ascii, double lat, double lng, boolean capital, int population, String id) {
        this.iso3 = iso3;
        this.city_ascii = city_ascii;
        this.lat = lat;
        this.lng = lng;
        this.capital = capital;
        this.population = population;
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public boolean isCapital() {
        return capital;
    }
    
    

    public String getCountryCode() {
        return iso3;
    }

    public double getPopulation() {
        return population;
    }
    
    

    @Override
    public String toString() {
        return "City{" + "iso3=" + iso3 + ", city_ascii=" + city_ascii + ", lat=" + lat + ", lng=" + lng + ", capital=" + capital + ", population=" + population + ", id=" + id + '}';
    }
}
