package PyramidsPKG;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PyramidCSVDAO implements DAO{

    @Override
    public List<Pyramid> getData(String path) {
        
        
        List<Pyramid> records = new ArrayList<>();
        File f = new File(path);
        try {
            Scanner s = new Scanner(f);
            
            /*eleminate the header (the first line)*/
            s.nextLine();
            
            while (s.hasNextLine()) {
                
                /* read next line in the file and get the columns data (seprated by , )*/
                String next = s.nextLine();
                String[] row = next.split(",", -1);
                
                /* parsing strings to it's proper type */
                String Pharaoh          = "".equals(row[0])  ? "" : row[0].trim();
                String Ancient_name     = "".equals(row[1])  ? "" : row[1].trim();
                String Modern_name      = "".equals(row[2])  ? "" : row[2].trim();
                int    Dynasty          = "".equals(row[3])  ? 0  : Integer.valueOf(row[3].trim());
                String Site             = "".equals(row[4])  ? "" : row[4].trim();
                double Base1_m          = "".equals(row[5])  ? 0  : Double.valueOf(row[5].trim());
                double Base2_m          = "".equals(row[6])  ? 0  : Double.valueOf(row[6].trim());
                double Height_m         = "".equals(row[7])  ? 0  : Double.valueOf(row[7].trim());
                double Slope_dec_degr	= "".equals(row[8])  ? 0  : Double.valueOf(row[8].trim());
                double Volume_cu_m	= "".equals(row[9])  ? 0  : Double.valueOf(row[9].replace(".", ""));
                double Latitude         = "".equals(row[10]) ? 0  : Double.valueOf(row[10].trim());
                double Longitude	= "".equals(row[11]) ? 0  : Double.valueOf(row[11].trim());
                String Type             = "".equals(row[12]) ? "" : row[12].trim();
                String Lepsius	        = "".equals(row[13]) ? "" : row[13].trim();
                String Material	        = "".equals(row[14]) ? "" : row[14].trim();
                String Comment          = "".equals(row[15]) ? "" : row[15].trim();
                
                Pyramid p = new Pyramid( Pharaoh,  Ancient_name,  Modern_name,  Dynasty,  Site,  Base1_m,  Base2_m,  Height_m,  Slope_dec_degr,  Volume_cu_m,  Latitude,  Longitude,  Type,  Lepsius,  Material,  Comment);
                records.add(p);
//                System.out.println(p);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("number of imported records = " + records.size());
        return records;
    }
}
