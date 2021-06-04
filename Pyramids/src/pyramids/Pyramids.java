package pyramids;


import PyramidsPKG.Pyramid;
import PyramidsPKG.PyramidCSVDAO;
import java.util.Iterator;
import java.util.List;

public class Pyramids {

    public static void main(String[] args) {
        
        String path = "E:\\iti\\10 - JAVA _ UML\\03 - exercise\\Pyramids\\pyramids.csv";
        
        PyramidCSVDAO dataset = new PyramidCSVDAO();
        List<Pyramid> d = dataset.getData(path);
        
        for (Iterator<Pyramid> iterator = d.iterator(); iterator.hasNext();) {
            Pyramid next = iterator.next();
            System.out.println(next);
            
        }
    }
}
