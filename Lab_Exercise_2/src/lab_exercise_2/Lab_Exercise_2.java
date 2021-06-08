
package lab_exercise_2;
public class Lab_Exercise_2 {
    
    public static boolean stringcheck(String a){
         for(int i=0 ; i<a.length() ; i++){
                if (! Character.isLetter(a.charAt(i))){
                    return false;
                }
            }
            return true;
    }
    
    public static void main(String[] args) {
        
        // method refrenceing 
        CheckString c = Lab_Exercise_2::stringcheck;
        System.out.println(c.check("salah"));
        System.out.println(c.check("salah 123"));
    }
}
