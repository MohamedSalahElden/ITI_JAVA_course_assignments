
package CitiesAndCountries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityDAO implements DAO<City>{

    @Override
    public List<City> getData(String path) {
        List<City> data = new ArrayList<>();
        
        File f = new File(path);
        
        try {
            Scanner s = new Scanner(f);
            s.nextLine();
            while (s.hasNextLine()){
                String line =  s.nextLine();
                String[] temp = line.split("," , -1);
                String iso3       = "".equals(temp[0]) ? "" : temp[0].trim();
                String city_ascii = "".equals(temp[1]) ? "" : temp[1].trim();
                double lat        = "".equals(temp[2]) ? 0  : Double.valueOf(temp[2].trim());
                double lng        = "".equals(temp[3]) ? 0  : Double.valueOf(temp[3].trim());
                boolean capital   = "yes".equals(temp[4]);
                int population    = "".equals(temp[5]) ? 0  : Integer.valueOf(temp[5].trim().replace(".", ""));
                String id         = "".equals(temp[6]) ? "" : temp[6].trim();

                City c = new City( iso3,  city_ascii,  lat,  lng,  capital,  population,  id);
                data.add(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("number of city records = " + data.size());
        return data;
        
    }
    
}
