/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labex2;

/**
 *
 * @author moham
 */
public class StringUtils {
    static String  betterString(String a , String b , CompareStr comp){
        return comp.compare(a, b) == true ? a : b;
    }
}
