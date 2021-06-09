
package lab_exercise_4;

import PyramidsPKG.Pyramid;
import PyramidsPKG.PyramidCSVDAO;
import java.util.List;


public class Lab_Exercise_4 {

    public static void main(String[] args) {
        
        String path = "E:\\iti\\10 - JAVA _ UML\\03 - exercise\\Pyramids\\pyramids.csv";
        
        PyramidCSVDAO dataset = new PyramidCSVDAO();
        List<Pyramid> d = dataset.getData(path);
        
        int size = d.size();
              
        d.stream().map(Pyramid::getHeight_m).sorted().toList().forEach(System.out::println);
        
        double avarage = d.stream().map(t -> t.getHeight_m()).reduce(Double::sum).get()/size;
        double lowerQuartile = d.stream().map(Pyramid::getHeight_m).sorted().toList().get((int)(size* 1/4));
        double median        = d.stream().map(Pyramid::getHeight_m).sorted().toList().get((int)(size* 1/2));
        double upperQuartile = d.stream().map(Pyramid::getHeight_m).sorted().toList().get((int)(size* 3/4));
        
        
        System.out.println("avarage of height        = " + avarage);
        System.out.println("lowerQuartile of height  = " + lowerQuartile);
        System.out.println("median of height         = " + median);
        System.out.println("upperQuartile of height  = " + upperQuartile);
        
        
    }
    
}
