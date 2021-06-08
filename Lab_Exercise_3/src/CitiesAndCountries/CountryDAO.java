
package CitiesAndCountries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryDAO implements DAO<Country>{

    @Override
    public List<Country> getData(String path) {
        List<Country> data = new ArrayList<>();
        
        File f = new File(path);
        
        try {
            Scanner s = new Scanner(f);
            s.nextLine();
            while (s.hasNextLine()){
                String line =  s.nextLine();
                String[] temp = line.split("," , -1);
                
                String country = temp[0].trim();
                String iso3 = temp[1].trim();
                
                Country c  = new Country(iso3, country);
//                System.out.println(c);  
                data.add(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("number of country records = " + data.size());
        return data;
    }
    
}
