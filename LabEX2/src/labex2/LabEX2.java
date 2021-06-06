
package labex2;

public class LabEX2 {
    

    public static void main(String[] args) {
        String longer = StringUtils.betterString("longer string", "shorter", (s1, s2) -> s1.length() > s2.length());
        System.out.println(longer);
        
        String first = StringUtils.betterString("first", "second", (s1, s2) -> true);
        System.out.println(first);


   }
    
}
